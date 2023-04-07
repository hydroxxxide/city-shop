package com.example.cityshop.dto;

import com.example.cityshop.models.City;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class StreetDTO {
    private String name;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

}
