import Swal from "sweetalert2";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class AlertService {
    default_opts = {
        confirmButtonColor: '#2196F3',
        confirmButtonText: 'Có',
        cancelButtonColor: '#ff4b46',
        cancelButtonText: 'Không',
    };

    constructor() {

    }

    public fire(options?: any) {
        const opts = Object.assign(this.default_opts, options);
        return Swal.fire(opts);
    }
}
