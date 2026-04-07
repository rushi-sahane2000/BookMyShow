package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.TheaterRequest;
import com.cfs.BookMyShow.dto.UserRequest;
import com.cfs.BookMyShow.entity.City;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theaters")
@RequiredArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;

    @PostMapping
    public ResponseEntity<Theater> addTheater(@RequestBody TheaterRequest request)
    {
        return  ResponseEntity.ok(theaterService.addTheater(request));
    }


    @GetMapping
    public ResponseEntity<List<Theater>>  getAllTheater()
    {
        return ResponseEntity.ok(theaterService.getAllTheater());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theater> getTheaterById(@PathVariable Long id)
    {
        return  ResponseEntity.ok(theaterService.getTheaterById(id));
    }
    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<Theater>> getTheaterByCity(@PathVariable Long cityId)
    {
        return  ResponseEntity.ok(theaterService.getTheaterByCity(cityId));
    }

}
