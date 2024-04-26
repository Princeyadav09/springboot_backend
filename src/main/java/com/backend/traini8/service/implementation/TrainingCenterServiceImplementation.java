package com.backend.traini8.service.implementation;

import com.backend.traini8.exception.BusinessException;
import com.backend.traini8.model.TrainingCenter;
import com.backend.traini8.repository.TrainingCenterRepository;
import com.backend.traini8.service.TrainingCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TrainingCenterServiceImplementation implements TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
        try {
            // Set the current server timestamp as the createdOn time
            trainingCenter.setCreatedOn(Instant.now().getEpochSecond());
            // Save the training center
            return trainingCenterRepository.save(trainingCenter);
        } catch (Exception ex){
            throw new BusinessException("Error saving TrainingCenter: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<TrainingCenter> getFilteredTrainingCenters(String centerName, String centerCode, Long createdOn) {
        try {
            return trainingCenterRepository.findFilteredTrainingCenters(centerName, centerCode, createdOn);
        } catch (Exception ex){
            throw new BusinessException("Error getting TrainingCenters: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
