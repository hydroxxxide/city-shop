package com.example.cityshop.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ShopDTO {
    private String name;

    private Long city_id;

    private Long street_id;

    private String house;

    private LocalTime openingTime;

    private LocalTime closingTime;
}
