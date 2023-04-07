package com.example.cityshop.mappers;

import com.example.cityshop.dto.ShopDTO;
import com.example.cityshop.models.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public ShopMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ShopDTO convertToDTO(Shop shop){
        return modelMapper.map(shop, ShopDTO.class);
    }

    public Shop convertToEntity(ShopDTO shopDTO){
        return modelMapper.map(shopDTO, Shop.class);
    }
}
