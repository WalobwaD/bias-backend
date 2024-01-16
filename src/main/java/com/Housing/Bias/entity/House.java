package com.Housing.Bias.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private long houseId;

    @Column(name="address")
    private String address;
    @Column(name = "type")
    private String type;  // Assuming the type of the house is a String

    @Column(name="value")
    private long value;

    @Column(name="room")
    private long room;

    // One-to-one relationship with Sample entity
    @OneToOne(mappedBy = "house", cascade = CascadeType.ALL, orphanRemoval = true)
    private Sample sample;  


    public long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
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


    @Override
    public String toString() {
        return "House{" +
                "houseId=" + houseId +
                ", address='" + address + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", room=" + room +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return value == house.value && room == house.room && Objects.equals(houseId, house.houseId) && Objects.equals(address, house.address) && Objects.equals(type, house.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseId, address, type, value, room);
    }

    public House() {
    }

    public House(long houseId, String address, String type, long value, long room) {
        this.houseId = houseId;
        this.address = address;
        this.type = type;
        this.value = value;
        this.room = room;
    }
}

