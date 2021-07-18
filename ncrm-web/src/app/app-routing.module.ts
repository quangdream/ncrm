import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {MainComponent} from './layout/main/main.component';
import {LayoutModule} from './layout/layout.module';
import {errorRoute} from './layout/error/error.route';
import {UserRouteAccessService} from './core/login/user-route-access-service';

const routes: Routes = [

    {
        path: 'app',
        component: MainComponent,
        canActivate: [UserRouteAccessService],
        children: [
            {
                path: 'category-management',
                loadChildren: () => import('./features/category-management/category-management.module').then(m => m.CategoryManagementModule)
            },
            {
                path: 'intel',
                loadChildren: () => import('./features/about/about.module').then(m => m.AboutModule)
            },
            {
                path: 'settings',
                loadChildren: () => import('./features/settings/settings.module').then(m => m.SettingsModule)
            },
            {
                path: 'info',
                loadChildren: () => import('./features/info/info.module').then(m => m.InfoModule)
            },
            {path: '', redirectTo: 'category-management', pathMatch: 'full'},
            {path: '**', redirectTo: 'category-management', pathMatch: 'full'},
        ]
    },
    {
        path: 'login',
        loadChildren: () => import('./core/login/login.module').then(m => m.LoginModule),
    },
    {
        path: 'login-alt',
        loadChildren: () => import('./core/login_alt/login-alt.module').then(m => m.LoginAltModule),
    },
    {path: '', redirectTo: 'app', pathMatch: 'full'},
    {path: '**', redirectTo: 'app', pathMatch: 'full'},
    ...errorRoute
];

@NgModule({
    imports: [LayoutModule, RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
