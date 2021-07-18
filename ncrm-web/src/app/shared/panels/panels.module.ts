import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PanelComponent } from './panel/panel.component';
import { DialogsModule } from '../dialogs/dialogs.module';
import {TooltipModule} from 'ngx-bootstrap/tooltip';

@NgModule({
  declarations: [PanelComponent],
  imports: [
    TooltipModule,
    CommonModule,
    DialogsModule
  ],
  exports: [PanelComponent]
})
export class PanelsModule { }
