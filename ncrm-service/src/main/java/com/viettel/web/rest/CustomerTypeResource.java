package com.viettel.web.rest;

import com.viettel.domain.CustomerType;
import com.viettel.service.CustomerTypeService;
import com.viettel.service.dto.CustomerTypeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customerType")
public class CustomerTypeResource {

    @Autowired
    private CustomerTypeService customerTypeService;

    @PostMapping("/doSearch")
    public ResponseEntity doSearch(CustomerTypeDTO dto) {
        try {
            return ResponseEntity.ok(customerTypeService.doSearch(dto));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/saveUpdate")
    public ResponseEntity save(@RequestBody CustomerTypeDTO dto) {
        return ResponseEntity.ok(customerTypeService.saveData(dto));
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam Long customerTypeId) {
        return ResponseEntity.ok(customerTypeService.deleteData(customerTypeId));
    }
}
