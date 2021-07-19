package com.viettel.repository.dao;

import com.viettel.service.dto.CustomerTypeDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

@Repository
public class CustomerTypeDao {
    @PersistenceContext
    private EntityManager entityManager;

    public boolean checkDuplicate(CustomerTypeDTO dto) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select count(1) from CUSTOMER_TYPE WHERE STATUS = 1 and (upper(CODE) = upper(:code) or upper(NAME) = upper(:name)) ");
        if (dto.getCustomerTypeId() != null) {
            sql.append(" and CUSTOMER_TYPE_ID != :customerTypeId ");
        }
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("code", dto.getCode());
        query.setParameter("name", dto.getName());
        if (dto.getCustomerTypeId() != null) {
            query.setParameter("customerTypeId", dto.getCustomerTypeId());
        }
        Number rs = (Number) query.getSingleResult();
        return rs.intValue() > 0;
    }
}
