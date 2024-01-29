package com.Housing.Bias.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appraiser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long appraiserid;

    public Appraiser() {}
}
