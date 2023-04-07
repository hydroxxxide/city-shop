package com.example.cityshop.controllers;

import com.example.cityshop.dto.CityDTO;
import com.example.cityshop.dto.StreetDTO;
import com.example.cityshop.mappers.CityMapper;
import com.example.cityshop.mappers.StreetMapper;
import com.example.cityshop.models.City;
import com.example.cityshop.models.Street;
import com.example.cityshop.services.CityService;
import com.example.cityshop.services.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;
    private final CityMapper cityMapper;
    private final StreetService streetService;
    private final StreetMapper streetMapper;

    @Autowired
    public CityController(CityService cityService, CityMapper cityMapper, StreetService streetService, StreetMapper streetMapper) {
        this.cityService = cityService;
        this.cityMapper = cityMapper;
        this.streetService = streetService;
        this.streetMapper = streetMapper;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCity(@RequestBody CityDTO cityDTO) {
        try {
            City city = cityMapper.convertToEntity(cityDTO);
            cityService.saveCity(city);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDTO> getCityById(@PathVariable Long id) {
        try {
            City city = cityService.getCityById(id);
            CityDTO cityDTO = cityMapper.convertToDTO(city);
            return ResponseEntity.ok(cityDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}/streets")
    public ResponseEntity<List<StreetDTO>> getAllStreets(@PathVariable Long id) {
        try {
            City city = cityService.getCityById(id);
            List<Street> streets = streetService.getStreetsByCity(city);
            List<StreetDTO> streetDTOS = streets.stream()
                    .map(streetMapper::convertToDTO)
                    .toList();
            return ResponseEntity.ok(streetDTOS);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCity(@PathVariable Long id, @RequestBody CityDTO cityDTO) {
        try {
            City city = cityMapper.convertToEntity(cityDTO);
            city.setId(id);
            cityService.updateCity(id, city);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Long id) {
        try {
            cityService.deleteCity(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<CityDTO>> getAllCities() {
        try {
            List<City> cities = cityService.getAllCities();
            List<CityDTO> cityDTOs = cities.stream()
                    .map(cityMapper::convertToDTO)
                    .toList();
            return ResponseEntity.ok(cityDTOs);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

