import {Injectable} from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';
import {LoginService} from '../login/login.service';
import {ToastrService} from 'ngx-toastr';

@Injectable()
export class AuthExpiredInterceptor implements HttpInterceptor {
    constructor(
        private loginService: LoginService,
        private toastr: ToastrService,
    ) {
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(
            tap(
                (event: HttpEvent<any>) => {
                },
                (err: any) => {
                    if (err instanceof HttpErrorResponse) {
                        if (err.status === 401) {
                            this.loginService.logout();
                        }

                        if (err.status === 500) {
                            this.toastr.error('Có lỗi xảy ra, vui lòng thử lại sau.', 'Lỗi');
                        }

                        if (err.status === 0) {
                            this.toastr.error('Có lỗi xảy ra, vui lòng thử lại sau.', 'Lỗi');
                            this.loginService.logout();
                        }
                    }
                }
            )
        );
    }
}
