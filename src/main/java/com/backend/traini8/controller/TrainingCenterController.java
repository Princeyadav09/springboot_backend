package com.backend.traini8.controller;


import com.backend.traini8.model.TrainingCenter;
import com.backend.traini8.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping
    public ResponseEntity<TrainingCenter> createTrainingCenter(@RequestBody @Valid TrainingCenter trainingCenter) {
        return ResponseEntity.ok(trainingCenterService.createTrainingCenter(trainingCenter));
    }

    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(
            @RequestParam(required = false) String centerName,
            @RequestParam(required = false) String centerCode,
            @RequestParam(required = false) Long createdOn) {

        // Pass the query parameters to the service method to get the filtered list
        List<TrainingCenter> trainingCenters = trainingCenterService.getFilteredTrainingCenters(centerName, centerCode, createdOn);

        // Return the filtered list as the response
        return ResponseEntity.ok(trainingCenters);
    }
}
