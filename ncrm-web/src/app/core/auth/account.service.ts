import {Injectable} from '@angular/core';
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {HttpClient} from '@angular/common/http';
import {Observable, of, Subject} from 'rxjs';
import {map, shareReplay, tap} from 'rxjs/operators';

import {Account} from '../../shared/model/user/account.model';
import {API_ENDPOINT_URL} from '../../app-config.service';

@Injectable({providedIn: 'root'})
export class AccountService {
    private userIdentity: Account;
    private authenticated = false;
    private authenticationState = new Subject<any>();
    private accountCache$: Observable<Account>;

    constructor(
        private sessionStorage: SessionStorageService,
        private localStorage: LocalStorageService,
        private http: HttpClient
    ) {
    }

    private fetch(): Observable<Account> {
        return this.http.get<Account>(API_ENDPOINT_URL + '/account')
            .pipe(
                map(response => response)
            );
    }


    save(account: Account): Observable<Account> {
        return this.http.post<Account>(API_ENDPOINT_URL + '/account', account);
    }

    authenticate(identity) {
        this.userIdentity = identity;
        this.authenticated = identity !== null;
        this.authenticationState.next(this.userIdentity);
    }

    hasAnyAuthority(authorities: string[] | string): boolean {
        if (!authorities || !authorities.length) {
            return true;
        }

        if (!this.authenticated || !this.userIdentity || !this.userIdentity.authorities) {
            return false;
        }

        if (!Array.isArray(authorities)) {
            authorities = [authorities];
        }

        return authorities.some((authority: string) => this.userIdentity.authorities.includes(authority));
    }

    identity(force?: boolean): Observable<Account> {
        if (force) {
            this.accountCache$ = null;
        }

        if (!this.accountCache$) {
            this.accountCache$ = this.fetch().pipe(
                tap(
                    account => {
                        if (account) {
                            this.userIdentity = account;
                            this.authenticated = true;
                        } else {
                            this.userIdentity = null;
                            this.authenticated = false;
                        }
                        this.authenticationState.next(this.userIdentity);
                    },
                    () => {
                        this.userIdentity = null;
                        this.authenticated = false;
                        this.authenticationState.next(this.userIdentity);
                    }
                ),
                shareReplay()
            );
        }
        return this.accountCache$;
    }

    isAuthenticated(): boolean {
        return this.authenticated;
    }

    isIdentityResolved(): boolean {
        return this.userIdentity !== undefined;
    }

    getAuthenticationState(): Observable<any> {
        return this.authenticationState.asObservable();
    }

    getImageUrl(): string {
        return this.isIdentityResolved() ? this.userIdentity.imageUrl : null;
    }

    getToken() {
        return this.localStorage.retrieve('authenticationToken') || this.sessionStorage.retrieve('authenticationToken');
    }
}
