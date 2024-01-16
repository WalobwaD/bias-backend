package com.Housing.Bias.repository;

import com.Housing.Bias.entity.ForbiddenWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForbiddenWordRepository extends JpaRepository <ForbiddenWord, Long> {
    List<ForbiddenWord> findAll();
}
