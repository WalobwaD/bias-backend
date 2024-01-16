package com.Housing.Bias.repository;

import com.Housing.Bias.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SampleRepository extends JpaRepository <Sample, Long> {
    Optional<Sample> findById(Long id);
    List<Sample> findBySampleId(Long sampleId);

}
