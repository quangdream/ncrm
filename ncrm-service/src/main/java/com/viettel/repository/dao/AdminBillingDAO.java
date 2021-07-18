package com.viettel.repository.dao;

import com.viettel.service.dto.BillingDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminBillingDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public List<BillingDTO> searchBilling(BillingDTO dto) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("   b.id, ");
        sql.append("   b.cust_name, ");
        sql.append("   b.code, ");
        sql.append("   b.address, ");
        sql.append("   b.post_code, ");
        sql.append("   b.phone, ");
        sql.append("   b.email, ");
        sql.append("   b.total_price, ");
        sql.append("   b.status, ");
        sql.append("   DATE_FORMAT(b.create_date, '%d/%m/%Y %T') create_date, ");
        sql.append("   b.des , ");
        sql.append("   count(bdt.id) total_item");
        sql.append(" FROM billing b ");
        sql.append(" LEFT JOIN billing_dtl bdt ON b.id = bdt.billing_id ");
        sql.append(" WHERE 1=1 ");
        if (StringUtils.isNotBlank(dto.getCustName())) {
            sql.append(" AND LOWER(b.cust_name) like LOWER(CONCAT('%',:custName,'%')) ");
        }

        if (StringUtils.isNotBlank(dto.getPhone())) {
            sql.append(" AND LOWER(b.phone) like LOWER(CONCAT('%',:phone,'%')) ");
        }

        if (StringUtils.isNotBlank(dto.getEmail())) {
            sql.append(" AND LOWER(b.email) like LOWER(CONCAT('%',:email,'%')) ");
        }

        if (StringUtils.isNotBlank(dto.getAddress())) {
            sql.append(" AND LOWER(b.address) like LOWER(CONCAT('%',:address,'%')) ");
        }

        if (StringUtils.isNotBlank(dto.getCode())) {
            sql.append(" AND LOWER(b.code) = LOWER(:code) ");
        }


        if (dto.getId() != null) {
            sql.append(" AND b.id =:billingId ");
        }


        sql.append(" GROUP BY ");
        sql.append("   b.id, ");
        sql.append("   b.cust_name, ");
        sql.append("   b.code, ");
        sql.append("   b.address, ");
        sql.append("   b.post_code, ");
        sql.append("   b.phone, ");
        sql.append("   b.email, ");
        sql.append("   b.total_price, ");
        sql.append("   b.status, ");
        sql.append("   b.create_date, ");
        sql.append("   b.des  ");
        sql.append(" ORDER BY b.id desc ");

        Map<String,Object> hashMapParams = new HashMap();
        if (StringUtils.isNotBlank(dto.getCustName())) {
            hashMapParams.put("custName",dto.getCustName());
        }

        if (dto.getId() != null) {
            hashMapParams.put("billingId",dto.getId());
        }

        if (StringUtils.isNotBlank(dto.getPhone())) {
            hashMapParams.put("phone",dto.getPhone());
        }

        if (StringUtils.isNotBlank(dto.getEmail())) {
            hashMapParams.put("email",dto.getEmail());
        }

        if (StringUtils.isNotBlank(dto.getAddress())) {
            hashMapParams.put("address",dto.getAddress());
        }

        if (StringUtils.isNotBlank(dto.getCode())) {
            hashMapParams.put("code",dto.getCode());
        }
        List<BillingDTO> result = namedParameterJdbcTemplate.query(sql.toString(), hashMapParams, BeanPropertyRowMapper.newInstance(BillingDTO.class));



        return result;
    }

}
