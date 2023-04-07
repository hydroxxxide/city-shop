package com.example.cityshop.repositories;

import com.example.cityshop.models.City;
import com.example.cityshop.models.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {
    List<Street> findByCity(City city);
}
