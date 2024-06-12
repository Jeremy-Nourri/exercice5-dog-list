package org.example.exercice5doglist.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;


@Entity
public class Dog {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String breed;

    private LocalDate dateOfBirth;

    public Dog(String name, String breed, LocalDate dateOfBirth) {
        this.name = name;
        this.breed  = breed;
        this.dateOfBirth = dateOfBirth;
    }

    public Dog() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
