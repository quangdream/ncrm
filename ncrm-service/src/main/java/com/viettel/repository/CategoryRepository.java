package com.viettel.repository;

import com.viettel.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Category entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /*BEGIN ADMIN*/
    @Query(value = "SELECT * FROM category WHERE code =?1", nativeQuery = true)
    Category findCatByCode(String code);
    /*END ADMIN*/
}
