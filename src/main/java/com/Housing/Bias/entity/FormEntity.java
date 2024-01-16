package com.Housing.Bias.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "form")
public class FormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id")
    private long formId;

    @Column(name="address")
    private String address;

    @Column(name = "type")
    private String type;  // Assuming the type of the house is a String

    @Column(name="value")
    private long value;

    @Column(name="room")
    private long room;
}
