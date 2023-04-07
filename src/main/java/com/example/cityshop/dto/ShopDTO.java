package com.example.cityshop.dto;

import com.example.cityshop.models.City;
import com.example.cityshop.models.Street;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;

@Data
public class ShopDTO {
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "street_id", referencedColumnName = "id")
    private Street street;

    private String house;

    private LocalTime openingTime;

    private LocalTime closingTime;
}
