package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.CityRequest;
import com.cfs.BookMyShow.entity.City;
import com.cfs.BookMyShow.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private CityRepository cityRepository;

    public City addCity(CityRequest request) {

        // Optional: check duplicate city
        if (cityRepository.existsByName(request.getName())) {
            throw new RuntimeException("City already exists: " + request.getName());
        }

        City city = City.builder()
                .name(request.getName())
                .state(request.getState())
                .build();

        return cityRepository.save(city);
    }

    public List<City>  getAllCities()
    {
        return  cityRepository.findAll();
    }

    public City getCityById(Long id)
    {
        return  cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("City not Found with id"+id));

    }

}
