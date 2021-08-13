package com.example.thi_thmd4_2.model;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @Min(0)
    private Long area;


    @Min(0)
    private Long population;


    @Min(0)
    private Long GDP;

    private String description;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public City(Long id, String name, Long area, Long population, Long GDP, String description, Country country) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.population = population;
        this.GDP = GDP;
        this.description = description;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
