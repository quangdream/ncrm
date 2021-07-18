package com.viettel.repository;

import com.viettel.domain.AppParams;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the AppParams entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppParamsRepository extends JpaRepository<AppParams, Long> {
    /*BEGIN ADMIN*/
    @Query(value = "SELECT * FROM app_params WHERE app_type =?1 ORDER BY app_name", nativeQuery = true)
    List<AppParams> getAllByAppType(String appType);
    /*END ADMIN*/
}
