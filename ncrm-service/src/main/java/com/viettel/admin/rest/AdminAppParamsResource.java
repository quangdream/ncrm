package com.viettel.admin.rest;

import com.viettel.admin.service.AdminAppParamsService;
import com.viettel.domain.AppParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminAppParamsResource {
    @Autowired
    private AdminAppParamsService appParamsService;

    @GetMapping("/get-by-app-type")
    public List<AppParams> getByAppType(@RequestParam String appType) {
        return appParamsService.getAllByAppType(appType);
    }
}
