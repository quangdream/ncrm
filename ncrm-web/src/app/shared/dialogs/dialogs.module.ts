import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { DialogsService } from './dialogs.service';
import {ModalModule} from 'ngx-bootstrap/modal';

@NgModule({
  declarations: [ConfirmDialogComponent],
  entryComponents: [ConfirmDialogComponent],
  imports: [
    CommonModule,
    ModalModule
  ],
  providers: [DialogsService]
})
export class DialogsModule { }
