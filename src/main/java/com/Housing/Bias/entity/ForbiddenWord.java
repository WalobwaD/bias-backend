package com.Housing.Bias.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="words")
@Data
public class ForbiddenWord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String word;
}
