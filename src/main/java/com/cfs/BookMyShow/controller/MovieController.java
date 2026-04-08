package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.MovieRequest;
import com.cfs.BookMyShow.entity.Movie;
import com.cfs.BookMyShow.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody MovieRequest request)
    {
        return ResponseEntity.ok(movieService.addMovie(request));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie()
    {
        return  ResponseEntity.ok(movieService.getAllMovie());
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long movieId)
    {
        return ResponseEntity.ok(movieService.getMovieById(movieId));
    }

    @GetMapping("/title")
    public ResponseEntity<List<Movie>> searchByTitle(@RequestParam String title)
    {
        return  ResponseEntity.ok(movieService.searchByTitle(title));
    }

    @GetMapping("/genre")
    public ResponseEntity<List<Movie>> searchByGenre(@RequestParam String genre)
    {
        return  ResponseEntity.ok(movieService.searchByGenre(genre));
    }
    @GetMapping("/language")
    public ResponseEntity<List<Movie>> searchByLanguage(@RequestParam String language)
    {
        return  ResponseEntity.ok(movieService.searchByLanguage(language));
    }

    @DeleteMapping("/{movieId}")
    public String deleteMovieById(@PathVariable Long movieId )
    {
        ResponseEntity.ok(movieService.deleteMovieById(movieId));
        return "movie delete successfully id:"+movieId;
    }
    @PostMapping("/{id}/movie")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody MovieRequest request)
    {
        return ResponseEntity.ok(movieService.updateMovie(id,request));
    }
}
