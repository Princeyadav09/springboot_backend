package com.backend.traini8.repository;

import com.backend.traini8.model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainingCenterRepository extends JpaRepository<TrainingCenter, Long> {

    @Query("SELECT tc FROM TrainingCenter tc WHERE " +
            "(:centerName IS NULL OR tc.centerName LIKE %:centerName%) AND " +
            "(:centerCode IS NULL OR tc.centerCode = :centerCode) AND " +
            "(:createdOn IS NULL OR tc.createdOn = :createdOn)")
    List<TrainingCenter> findFilteredTrainingCenters(
            @Param("centerName") String centerName,
            @Param("centerCode") String centerCode,
            @Param("createdOn") Long createdOn);
}
