package com.example.cityshop.dto;

import com.example.cityshop.models.City;
import com.example.cityshop.models.Street;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ShopFilterDTO {
    private String name;

    private City city;

    private Street street;

    private String house;

    private LocalTime openingTime;

    private LocalTime closingTime;
}
