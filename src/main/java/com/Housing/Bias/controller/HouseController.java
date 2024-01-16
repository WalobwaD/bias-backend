package com.Housing.Bias.controller;

import com.Housing.Bias.entity.House;
import com.Housing.Bias.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/house")
@CrossOrigin(origins = "http://localhost:3000")
public class HouseController {
    @Autowired
    private HouseService houseservice;

    @GetMapping
    public List<House> getHouse(){
        return houseservice.getAllHouses();
    }

    @PostMapping
    public List<House> postHouses(@RequestBody List<House> houses) {
        return houseservice.createHouses(houses);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHouse(@PathVariable Long id) {
        if (houseservice.deleteHouse(id)) {
            return new ResponseEntity<>("House with ID " + id + " deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("House with ID " + id + " not found", HttpStatus.NOT_FOUND);
        }
    }



}