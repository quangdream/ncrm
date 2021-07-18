import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {LoginComponent} from './login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {NgxSpinnerModule} from "ngx-spinner";

@NgModule({
    declarations: [LoginComponent],
    imports: [
        FormsModule,
        CommonModule,
        ReactiveFormsModule,
        NgxSpinnerModule,
        RouterModule.forChild([
            {
                path: '',
                component: LoginComponent
            }
        ])
    ]
})
export class LoginModule {
}
