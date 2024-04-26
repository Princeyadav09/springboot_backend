package com.backend.traini8.service;

import com.backend.traini8.model.TrainingCenter;

import java.util.List;

public interface TrainingCenterService {
    TrainingCenter createTrainingCenter(TrainingCenter trainingCenter);

    List<TrainingCenter> getFilteredTrainingCenters(String centerName, String centerCode, Long createdOn);


}


