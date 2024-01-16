package com.Housing.Bias.controller;

import com.Housing.Bias.entity.Sample;
import com.Housing.Bias.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sample")
@CrossOrigin(origins = "http://localhost:3000")
public class SampleController {

    @Autowired
    private SampleService sampleService;
    @GetMapping
    public List<Sample> getSample(){
      return sampleService.getAllSamples();
    }

    @PostMapping
    public List<Sample> postSample(@RequestBody List<Sample> samples) {
        return sampleService.createSamples(samples);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        if (sampleService.deleteSample(id)) {
            return new ResponseEntity<>("Sample with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Sample with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
