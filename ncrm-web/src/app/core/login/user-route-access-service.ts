import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {AccountService} from '../auth/account.service';
import {Observable} from 'rxjs';
import {LoginService} from './login.service';
import {map} from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class UserRouteAccessService implements CanActivate {
    constructor(
        private router: Router,
        private accountService: AccountService,
        private loginService: LoginService
    ) {
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> {
        const authorities = route.data['authorities'];
        // We need to call the checkLogin / and so the accountService.identity() function, to ensure,
        // that the client has a principal too, if they already logged in by the server.
        // This could happen on a page refresh.
        return this.checkLogin(authorities, state.url);
    }

    checkLogin(authorities: string[], url: string): Observable<boolean> {
        if (!this.accountService.getToken()) {
            // Kiem tra neu KHONG CO token --> FAIL
            return new Observable<boolean>(ob => {
                this.loginService.logout();
                ob.next(false);
            });
        } else {
            return this.accountService.identity().pipe(
                map(account => {
                    if (account) {
                        return true;
                    } else {
                        this.loginService.logout();
                        return false;
                    }
                })
            );
        }
    }

}
