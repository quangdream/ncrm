package com.viettel.service;

import com.viettel.config.Constants;
import com.viettel.domain.CustomerType;
import com.viettel.repository.CustomerTypeRepository;
import com.viettel.repository.dao.CustomerTypeDao;
import com.viettel.service.dto.BaseResponse;
import com.viettel.service.dto.CustomerTypeDTO;
import com.viettel.utils.AppConstant;
import com.viettel.utils.ResponseUtil;
import org.checkerframework.checker.units.qual.A;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerTypeService {
    @Autowired
    private CustomerTypeRepository customerTypeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerTypeDao customerTypeDao;

    public BaseResponse<List<CustomerType>> doSearch(CustomerTypeDTO dto) {
        List<CustomerType> ls = customerTypeRepository.findAll();
        return ResponseUtil.buildSuccessResponse(customerTypeRepository.findAll());
    }

    public BaseResponse<CustomerType> saveData(CustomerTypeDTO dto) {
        if (customerTypeDao.checkDuplicate(dto)) {
            return ResponseUtil.buildResponse(AppConstant.ResponseCode.DUPLICATED);
        }
        if (dto.getCustomerTypeId() ==  null) {
            CustomerType customerType = modelMapper.map(dto,CustomerType.class);
            customerTypeRepository.save(customerType);
            return ResponseUtil.buildResponse(AppConstant.ResponseCode.SUCCESS);
        } else {
            CustomerType customerType = customerTypeRepository.findById(dto.getCustomerTypeId()).get();
            customerType.setCode(dto.getCode());
            customerType.setName(dto.getName());
            customerTypeRepository.save(customerType);
            return ResponseUtil.buildResponse(AppConstant.ResponseCode.SUCCESS);
        }
    }

    public BaseResponse<CustomerType> deleteData(Long customerTypeId) {
        customerTypeRepository.deleteById(customerTypeId);
        return ResponseUtil.buildResponse(null);
    }
}
