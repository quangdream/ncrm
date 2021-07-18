import {Component, OnInit} from '@angular/core';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {CategoryModel} from '../category.model';
import {CategoryManagementService} from '../category-management.service';
import {SUCCESS_CODE} from '../../../app.constants';
import {ToastrService} from 'ngx-toastr';

@Component({
    selector: 'smart-category-form',
    templateUrl: './category-management-form.component.html'
})
export class CategoryManagementFormComponent implements OnInit {
    entity: any;
    form: FormGroup;

    constructor(
        public activeModal: NgbActiveModal,
        public fb: FormBuilder,
        private toastr: ToastrService,
        private categoryService: CategoryManagementService
    ) {
    }

    ngOnInit() {
        this.buildForm();
    }

    private buildForm() {
        this.form = this.fb.group({
            id: new FormControl(this.entity.id, []),
            code: new FormControl({value: this.entity.code, disabled: this.entity.code}, [Validators.required]),
            name: new FormControl(this.entity.name, [Validators.required]),
            des: new FormControl(this.entity.des, [])
        });
    }

    public onSubmit() {
        var dataObj: CategoryModel = {
            id: this.form.get('id').value,
            code: this.form.get('code').value,
            name: this.form.get('name').value,
            des: this.form.get('des').value,
        };

        this.categoryService.createUpdateCategory(dataObj).subscribe(response => {
            if ('CAT_ERR_DUPLICATE_CODE' == response.code) {
                this.toastr.warning("Mã loại sảm phầm bị trùng, vui lòng nhập giá trị khác", "Thông báo");
            }

            if (SUCCESS_CODE == response.code) {
                this.toastr.success("Lưu Loại sản phẩm thành công", "Thành công");
                this.activeModal.close('save_success');
            }
        });
    }

    public cancel() {
        this.activeModal.dismiss('cancel');
    }
}
