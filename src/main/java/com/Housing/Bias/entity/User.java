package com.Housing.Bias.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    private String name;
    private String email;
    private String password;
    private String registrationType;

    // address
    // company
    // license
    @OneToMany(mappedBy = "user")
    private List<House> houses = new ArrayList<>();

    public User(Long userid, String name, String email, String password, String registrationType) {
        this.userid = userid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationType = registrationType;
    }

    public User() {

    }
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, String registrationType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registrationType = registrationType;
    }


    public long getUserid() {
        return userid;
    }

    public void setUserId(Long id) {
        this.userid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(String registrationType) {
        this.registrationType = registrationType;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + userid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registrationType='" + registrationType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userid == user.userid && Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(registrationType, user.registrationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, name, email, password, registrationType);
    }
}
