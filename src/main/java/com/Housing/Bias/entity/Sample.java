package com.Housing.Bias.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="sample")
public class Sample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "sample_id")
    private long sampleId;

    @Column(name="address")
    private String address;


    @Column(name = "type")
    private String type;

    @Column(name="value")
    private long value;

    @Column(name="room")
    private long room;


    @OneToOne
    @JoinColumn(name = "house_id")
    private House house;

    public long getSampleId() {
        return sampleId;
    }

    public void setSampleId(long sampleId) {
        this.sampleId = sampleId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getRoom() {
        return room;
    }

    public void setRoom(long room) {
        this.room = room;
    }

    public Sample() {
    }

    public Sample(long sampleId, String address, String type, long value, long room) {
        this.sampleId = sampleId;
        this.address = address;
        this.type = type;
        this.value = value;
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sample sample = (Sample) o;
        return sampleId == sample.sampleId && value == sample.value && room == sample.room && Objects.equals(address, sample.address) && Objects.equals(type, sample.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sampleId, address, type, value, room);
    }

    @Override
    public String toString() {
        return "Sample{" +
                "sampleId=" + sampleId +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", room=" + room +
                '}';
    }
}
