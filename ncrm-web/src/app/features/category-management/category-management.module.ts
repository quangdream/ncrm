import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {SharedModule} from '../../shared/shared.module';
import {ColumnMenuModule} from '@progress/kendo-angular-grid';
import {CategoryManagementComponent} from './category-management.component';
import {CategoryManagementFormComponent} from './popup/category-management-form.component';

@NgModule({
    declarations: [
        CategoryManagementComponent,
        CategoryManagementFormComponent
    ],
    entryComponents: [
        CategoryManagementFormComponent
    ],
    imports: [
        ColumnMenuModule,
        SharedModule,
        RouterModule.forChild([
            {
                path: '',
                component: CategoryManagementComponent,
                data: {
                    breadcrumbs: ['Quản lý danh mục', 'Loại sản phẩm']
                }
            }
        ])
    ]
})
export class CategoryManagementModule {
}
