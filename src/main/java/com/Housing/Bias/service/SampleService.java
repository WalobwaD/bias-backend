package com.Housing.Bias.service;


import com.Housing.Bias.entity.Sample;
import com.Housing.Bias.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SampleService {
    private final SampleRepository sampleRepository;

    @Autowired
   public SampleService(SampleRepository sampleRepository){this.sampleRepository=sampleRepository;}

    public List<Sample> getAllSamples() {
        return sampleRepository.findAll();
    }

    public Optional<Sample> getSampleById(Long id) {
        return sampleRepository.findById(id);
    }

    public Sample createSample(Sample sample) {
        // Add business logic if needed before saving
        return sampleRepository.save(sample);
    }


    public Sample updateSample(Long id, Sample updatedSample) {
        // Add business logic if needed before updating
        if (sampleRepository.existsById(id)) {
            updatedSample.setSampleId(id);
            return sampleRepository.save(updatedSample);
        } else {
            // Handle the case where the sample with the given id doesn't exist
            return null;
        }
    }

        public boolean deleteSample(Long id) {
            // Add business logic if needed before deleting
            try {
                sampleRepository.deleteById(id);
                return true; // Return true on successful deletion
            } catch (EmptyResultDataAccessException e) {
                return false; // Return false if the house with the given ID is not found
            }
        }

        public List<Sample> getAllsamples() {
            return sampleRepository.findAll();
        }

        public List<Sample> createSamples(List<Sample> samples) {
            return sampleRepository.saveAll(samples);
        }

    }





