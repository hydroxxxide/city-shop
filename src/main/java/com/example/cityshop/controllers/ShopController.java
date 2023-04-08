package com.example.cityshop.controllers;

import com.example.cityshop.dto.ShopDTO;
import com.example.cityshop.dto.ShopFilterDTO;
import com.example.cityshop.mappers.ShopMapper;
import com.example.cityshop.models.City;
import com.example.cityshop.models.Shop;
import com.example.cityshop.models.Street;
import com.example.cityshop.services.CityService;
import com.example.cityshop.services.ShopService;
import com.example.cityshop.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final ShopService shopService;
    private final ShopMapper shopMapper;
    private final CityService cityService;
    private final StreetService streetService;


    @Autowired
    public ShopController(ShopService shopService, ShopMapper shopMapper, CityService cityService, StreetService streetService) {
        this.shopService = shopService;
        this.shopMapper = shopMapper;
        this.cityService = cityService;
        this.streetService = streetService;
    }


    @PostMapping("/")
    public ResponseEntity<Long> createShop(@RequestBody ShopDTO shopDTO) {
        try {
            Shop shop = shopMapper.convertToEntity(shopDTO);
            City city = cityService.getCityById(shopDTO.getCity_id());
            Street street = streetService.getStreetById(shopDTO.getStreet_id());
            shop.setCity(city);
            shop.setStreet(street);
            shopService.saveShop(shop);
            return ResponseEntity.ok(shop.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDTO> getShopById(@PathVariable Long id) {
        try {
            Shop shop = shopService.getShopById(id);
            ShopDTO shopDTO = shopMapper.convertToDTO(shop);
            return ResponseEntity.ok(shopDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateShop(@PathVariable Long id, @RequestBody ShopDTO shopDTO) {
        try {
            Shop shop = shopMapper.convertToEntity(shopDTO);
            shop.setId(id);
            shopService.updateShop(id, shop);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteShop(@PathVariable Long id) {
        try {
            shopService.deleteShop(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ShopFilterDTO>> getAllShops(@RequestParam(required = false) Long street_id,
                                                           @RequestParam(required = false) Long city_id,
                                                           @RequestParam(required = false) Boolean open) {
        try {
            List<Shop> shops = shopService.getAllShops();
            List<ShopFilterDTO> filteredShops = shops.stream()
                    .filter(shop -> street_id == null || shop.getStreet().getId().equals(street_id))
                    .filter(shop -> city_id == null || shop.getCity().getId().equals(city_id))
                    .filter(shop -> open == null || shopService.isOpen(shop.getOpeningTime(), shop.getClosingTime()) == open)
                    .map(shopMapper::convertToFilterDTO)
                    .toList();
            return ResponseEntity.ok(filteredShops);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

