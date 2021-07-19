import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {SharedModule} from '../../shared/shared.module';
import {ColumnMenuModule} from '@progress/kendo-angular-grid';
import {CustomerTypeComponent} from './customer-type.component';
import {CustomerTypeFormComponent} from './popup/customer-type-form.component';

@NgModule({
    declarations: [
        CustomerTypeComponent,
        CustomerTypeFormComponent
    ],
    entryComponents: [
        CustomerTypeFormComponent
    ],
    imports: [
        ColumnMenuModule,
        SharedModule,
        RouterModule.forChild([
            {
                path: '',
                component: CustomerTypeComponent,
                data: {
                    breadcrumbs: ['Quản lý danh mục', 'Đối tượng khách hàng']
                }
            }
        ])
    ]
})
export class CustomerTypeModule {
}
