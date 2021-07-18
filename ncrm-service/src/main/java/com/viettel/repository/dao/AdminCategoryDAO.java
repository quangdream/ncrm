package com.viettel.repository.dao;

import com.viettel.service.dto.CategoryDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AdminCategoryDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<CategoryDTO> searchCategory(String code, String name) {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ");
        sql.append("   ct.id, ct.code, ct.name, ct.des ");
        sql.append(" FROM category ct ");
        sql.append(" WHERE 1=1 ");
        if(StringUtils.isNotBlank(code)) {
            sql.append(" AND ct.code like CONCAT('%',:code,'%') ");
        }

        if(StringUtils.isNotBlank(name)) {
            sql.append(" AND ct.name like CONCAT('%',:name,'%') ");
        }
        sql.append(" GROUP BY ct.id ");
        sql.append(" ORDER BY ct.id ");

        Query query = entityManager.createNativeQuery(sql.toString(), "adminCategoryMapping");

        if(StringUtils.isNotBlank(code)) {
            query.setParameter("code", code);
        }

        if(StringUtils.isNotBlank(name)) {
            query.setParameter("name", name);
        }

        return query.getResultList();
    }
}
