package com.Housing.Bias.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Table(name = "form")
@Data
@SQLDelete(sql = "UPDATE form SET deleted = true WHERE form_id=?")
@Where(clause = "deleted=false")
public class FormEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id")
    private long formId;

    @Column(name="address")
    private String address;

    @Column(name="zip_code")
    private int zipCode;

    @Column(name="country")
    private String country;

    @Column(name="state")
    private String state;

    @Column(name = "distance_from_subject")
    private double distanceFromSubject;

    @Column(name = "sale")
    private String sale;

    @Column(name = "sale_price")
    private BigDecimal salePrice;

    @Column(name = "year_built")
    private int yearBuild;

    @Column(name = "style")
    private String style;

    @Column(name = "baths_full")
    private int bathsFull;

    @Column(name = "baths_half")
    private int bathsHalf;

    @Column(name = "garage_det")
    private int garageDet;

    @Column(name = "garage_att")
    private int garageAtt;

    @Column(name = "basement")
    private String basement;

    @Column(name = "unfinished_ful")
    private String unfinishedFull;

    @Column(name = "unfinished_partial")
    private String unfinishedPartial;

    @Column(name = "finished_ful")
    private String finishedFull;

    @Column(name = "finished_partial")
    private String finishedPartial;

    @Column(name = "house_condition")
    private String condition;

    @Column(name = "construction")
    private String construction;

    @Column(name = "qtyConstruction")
    private int qtyConstruction;

    @Column(name = "lotSize")
    private double lotSize;

    @Column(name = "utilities")
    private String utilities;

    @Column(name = "pool")
    private boolean pool;

    @Column(name = "corner")
    private String corner;

    @Column(name = "other_feature")
    private String otherFeatures;

    @Column(name = "other")
    private String other;

    @Column(name = "type")
    private String type;  // Assuming the type of the house is a String

    @Column(name="value")
    private long value;

    @Column(name="room")
    private long room;

    private boolean deleted = Boolean.FALSE;

}
