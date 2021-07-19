import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard.component';
import {ColumnMenuModule} from '@progress/kendo-angular-grid';
import {SharedModule} from '../../shared/shared.module';
import {RouterModule} from '@angular/router';

@NgModule({
  declarations: [DashboardComponent],
  imports: [
    ColumnMenuModule,
    SharedModule,
    RouterModule.forChild([
      {
        path: '',
        component: DashboardComponent,
        data: {
        }
      }
    ])
  ]
})
export class DashboardModule { }
