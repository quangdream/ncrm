import {Injectable} from '@angular/core';
import {flatMap} from 'rxjs/operators';
import {AccountService} from "../auth/account.service";
import {AuthServerProvider} from "../auth/auth-jwt.service";

@Injectable({providedIn: 'root'})
export class LoginService {
    constructor(private accountService: AccountService, private authServerProvider: AuthServerProvider) {
    }

    login(credentials) {
        return this.authServerProvider.login(credentials).pipe(flatMap(() => this.accountService.identity(true)));
    }

    logout() {
        this.authServerProvider.logout();
    }
}
