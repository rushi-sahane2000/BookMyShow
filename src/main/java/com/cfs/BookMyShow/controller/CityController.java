package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.CityRequest;
import com.cfs.BookMyShow.dto.MovieRequest;
import com.cfs.BookMyShow.entity.City;
import com.cfs.BookMyShow.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody CityRequest request)
    {
        return  ResponseEntity.ok(cityService.addCity(request));
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities()
    {

        return  ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id)
    {
        return ResponseEntity.ok(cityService.getCityById(id));
    }
}
