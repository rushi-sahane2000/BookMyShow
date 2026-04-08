package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.ScreenRequest;
import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/screens")
@RequiredArgsConstructor
public class ScreenController {

    private  final ScreenService screenService;

    @PostMapping
    public ResponseEntity<Screen> addScreen(@RequestBody ScreenRequest request)
    {
        return ResponseEntity.ok(screenService.addScreen(request));
    }

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreen()
    {
        return  ResponseEntity.ok(screenService.getAllScreen());
    }

    @GetMapping("/{screenId}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long screenId)
    {
        return  ResponseEntity.ok(screenService.getScreenById(screenId));
    }

    @GetMapping("/theater/{theaterId}")
    public ResponseEntity<List<Screen>> getScreenByTheater(@PathVariable Long theaterId)
    {
        return ResponseEntity.ok(screenService.getScreenByTheater(theaterId));
    }
}
