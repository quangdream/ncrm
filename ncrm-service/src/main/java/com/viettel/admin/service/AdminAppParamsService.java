package com.viettel.admin.service;

import com.viettel.domain.AppParams;
import com.viettel.repository.AppParamsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service class for managing users.
 */
@Service
@Transactional
public class AdminAppParamsService {
    private final Logger log = LoggerFactory.getLogger(AdminAppParamsService.class);

    @Autowired
    private AppParamsRepository appParamsRepository;

    public List<AppParams> getAllByAppType(String appType) {
        return appParamsRepository.getAllByAppType(appType);
    }
}
