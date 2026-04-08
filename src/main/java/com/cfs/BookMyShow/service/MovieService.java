package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.MovieRequest;
import com.cfs.BookMyShow.entity.Movie;
import com.cfs.BookMyShow.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie addMovie(MovieRequest request) {

        Movie movie = Movie.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .genre(request.getGenre())
                .language(request.getLanguage())
                .durationMinutes(request.getDurationInMinutes())
                .rating(request.getRating())
                .releaseDate(request.getReleaseDate())
                .posterUrl(request.getPosterUrl())
                .build();

        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovie()
    {
        return  movieRepository.findAll();
    }

    public Movie getMovieById(Long movieId)
    {
        return movieRepository.findById(movieId)
                .orElseThrow(()->new RuntimeException("Movie Not found With id "+movieId));
    }

    public List<Movie> searchByTitle(String title)
    {
        return  movieRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<Movie> searchByGenre(String genre)
    {
        return  movieRepository.findByGenre(genre);
    }
    public List<Movie> searchByLanguage(String language)
    {
        return  movieRepository.findByTitleContainingIgnoreCase(language);
    }

    //delete Movie
    public String deleteMovieById(Long id)
    {
        Movie movie=movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found with Id "+id));

        movieRepository.delete(movie);
        return "Delete Movie SuccessFully with Id"+id;
    }

    //Update Movie
    public Movie updateMovie(Long id, MovieRequest request) {

        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with Id " + id));

        if (request.getTitle() != null)
            existingMovie.setTitle(request.getTitle());

        if (request.getGenre() != null)
            existingMovie.setGenre(request.getGenre());

        if (request.getLanguage() != null)
            existingMovie.setLanguage(request.getLanguage());

        if (request.getRating() != null)
            existingMovie.setRating(request.getRating());

        if (request.getDescription() != null)
            existingMovie.setDescription(request.getDescription());

        if (request.getDurationInMinutes() != null)
            existingMovie.setDurationMinutes(request.getDurationInMinutes());

        if (request.getReleaseDate() != null)
            existingMovie.setReleaseDate(request.getReleaseDate());

        if (request.getPosterUrl() != null)
            existingMovie.setPosterUrl(request.getPosterUrl());

        return movieRepository.save(existingMovie);
    }

}
