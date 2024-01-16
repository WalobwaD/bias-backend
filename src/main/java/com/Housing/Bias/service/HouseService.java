package com.Housing.Bias.service;

import com.Housing.Bias.entity.House;
import com.Housing.Bias.entity.Sample;
import com.Housing.Bias.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class HouseService {

    private HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }

    public Optional<House> getHouseById(Long id) {
        return houseRepository.findById(id);
    }

    public House createHouse(House house) {
        // Add business logic if needed before saving
        return houseRepository.save(house);
    }

    public House updateHouse(Long id, House updatedHouse) {
        // Add business logic if needed before updating
        if (houseRepository.existsById(id)) {
            updatedHouse.setHouseId(id);
            return houseRepository.save(updatedHouse);
        } else {
            // Handle the case where the house with the given id doesn't exist
            return null;
        }
    }

    public boolean deleteHouse(Long id) {
        // Add business logic if needed before deleting
        try {
            houseRepository.deleteById(id);
            return true; // Return true on successful deletion
        } catch (EmptyResultDataAccessException e) {
            return false; // Return false if the house with the given ID is not found
        }
    }

    public List<House> getAllhouses() {
        return houseRepository.findAll();
    }

    public List<House> createHouses(List<House> houses) {
        return houseRepository.saveAll(houses);
    }



    public Optional<House> findBestMatchHouse(Sample sample) {
        List<House> allHouses = houseRepository.findAll();

        // Use Comparator to find the house with the closest value to the sample house
        Optional<House> bestMatchHouse = allHouses.stream()
                .min(Comparator.comparingLong(house ->
                        Math.abs(house.getValue() - sample.getValue())));

        return bestMatchHouse;
    }

}
