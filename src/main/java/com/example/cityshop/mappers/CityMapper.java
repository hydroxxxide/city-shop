package com.example.cityshop.mappers;

import com.example.cityshop.dto.CityDTO;
import com.example.cityshop.models.City;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public CityMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public CityDTO convertToDTO(City city){
        return modelMapper.map(city, CityDTO.class);
    }

    public City convertToEntity(CityDTO cityDTO){
        return modelMapper.map(cityDTO, City.class);
    }
}
