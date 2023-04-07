package com.example.cityshop.mappers;

import com.example.cityshop.dto.StreetDTO;
import com.example.cityshop.models.Street;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StreetMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public StreetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public StreetDTO convertToDTO(Street street){
        return modelMapper.map(street, StreetDTO.class);
    }

    public Street convertToEntity(StreetDTO streetDTO){
        return modelMapper.map(streetDTO, Street.class);
    }
}
