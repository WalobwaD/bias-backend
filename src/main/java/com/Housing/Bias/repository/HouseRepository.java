package com.Housing.Bias.repository;

import com.Housing.Bias.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Long> {

    List<House> findByHouseId(Long houseId);

}
