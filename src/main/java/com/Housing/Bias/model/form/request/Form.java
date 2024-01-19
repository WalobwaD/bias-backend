package com.Housing.Bias.model.form.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Form {

    private String address;
    private int zipCode;
    private String country;
    private String state;
    private double distanceFromSubject;
    private String sale;
    private BigDecimal salePrice;
    private int yearBuild;
    private String style;
    private int bathsFull;
    private int bathsHalf;
    private int garageDet;
    private int garageAtt;
    private String basement;
    private String unfinishedFull;
    private String unfinishedPartial;
    private String finishedFull;
    private String finishedPartial;
    private String condition;
    private String construction;
    private int qtyConstruction;
    private double lotSize;
    private String utilities;
    private boolean pool;
    private String corner;
    private String otherFeatures;
    private String other;
    private String type;
    private long value;
    private long room;
}
