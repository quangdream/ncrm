import {Component, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerTypeModel} from '../customerType.model';
import {CustomerTypeService} from '../customer-type.service';
import {SUCCESS_CODE, DUPLICATED} from '../../../app.constants';
import {ToastrService} from 'ngx-toastr';

@Component({
    selector: 'customer-type-form',
    templateUrl: './customer-type-form.component.html'
})
export class CustomerTypeFormComponent implements OnInit {
    entity: any;
    form: FormGroup;

    constructor(
        public activeModal: NgbActiveModal,
        public fb: FormBuilder,
        private toastr: ToastrService,
        private categoryService: CustomerTypeService
    ) {
    }

    ngOnInit() {
        this.buildForm();
    }

    private buildForm() {
        this.form = this.fb.group({
            customerTypeId: new FormControl(this.entity.customerTypeId, []),
            code: new FormControl(this.entity.code, [Validators.required]),
            name: new FormControl(this.entity.name, [Validators.required])
        });
    }

    public onSubmit() {
        const dataObj: CustomerTypeModel = {
            customerTypeId: this.form.get('customerTypeId').value,
            code: this.form.get('code').value,
            name: this.form.get('name').value
        };

        this.categoryService.saveUpdate(dataObj).subscribe(response => {
            if (DUPLICATED === response.code) {
                this.toastr.warning('Mã hoặc tên đối tượng khách hàng đã tồn tại', 'Thông báo');
            }
            if (SUCCESS_CODE === response.code) {
                this.toastr.success('Ghi lại thành công', 'Thành công');
                this.activeModal.close('save_success');
            }
        });
    }

    public cancel() {
        this.activeModal.dismiss('cancel');
    }
}
