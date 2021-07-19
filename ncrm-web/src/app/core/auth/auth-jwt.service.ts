import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';
import {LocalStorageService, SessionStorageService} from 'ngx-webstorage';
import {API_ENDPOINT_URL} from '../../app-config.service';
import {Router} from '@angular/router';
import {AccountService} from './account.service';


@Injectable({providedIn: 'root'})
export class AuthServerProvider {
    constructor(
        private router: Router,
        private http: HttpClient,
        private accountService: AccountService,
        private $localStorage: LocalStorageService,
        private $sessionStorage: SessionStorageService) {
    }

    login(credentials): Observable<any> {
        function authenticateSuccess(resp) {
            this.$localStorage.store('logged_user', credentials.username);
            const jwt = resp.body.id_token;
            this.storeAuthenticationToken(jwt, credentials.rememberMe);
            return jwt;
        }

        return this.http.post(`${API_ENDPOINT_URL}/admin/authenticate`, credentials, {observe: 'response'}).pipe(map(authenticateSuccess.bind(this)));
    }

    storeAuthenticationToken(jwt, rememberMe) {
        if (rememberMe) {
            this.$localStorage.store('authenticationToken', jwt);
        } else {
            this.$sessionStorage.store('authenticationToken', jwt);
        }
    }

    logout(): void {
        this.$localStorage.clear('authenticationToken');
        this.$sessionStorage.clear('authenticationToken');
        this.$localStorage.clear('logged_user');
        this.accountService.authenticate(null);

        this.router.navigate(['/login']);
    }
}
