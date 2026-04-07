package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.ShowRequest;
import com.cfs.BookMyShow.entity.Show;
import com.cfs.BookMyShow.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @PostMapping
    public ResponseEntity<Show> addShow(@RequestBody ShowRequest request)
    {
        return  ResponseEntity.ok(showService.addShow(request));
    }
    @GetMapping
    public ResponseEntity<List<Show>> getAllShow()
    {
        return  ResponseEntity.ok(showService.getAllShow());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Show> getShowById(@PathVariable Long showId)
    {
        return ResponseEntity.ok(showService.getShowById(showId));
    }
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Show>> getShowByMovie(@PathVariable Long movieId)
    {
        return ResponseEntity.ok(showService.getShowByMovie(movieId));
    }
    @GetMapping("/movie/{movieId}/date")
    public ResponseEntity<List<Show>>
    getShowByMovieDate(@PathVariable Long movieId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate)
    {
        return ResponseEntity.ok(showService.getShowByMovieDate(movieId,localDate));
    }
}
