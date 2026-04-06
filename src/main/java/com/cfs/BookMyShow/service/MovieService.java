package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.entity.Movie;
import com.cfs.BookMyShow.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie)
    {
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
        return  movieRepository.findTitleContainingIgnoreCase(title);
    }
    public List<Movie> searchByGenre(String genre)
    {
        return  movieRepository.findByGenre(genre);
    }
    public List<Movie> searchByLanguage(String language)
    {
        return  movieRepository.findTitleContainingIgnoreCase(language);
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
    public Movie updateMovie(Long id,Movie movie)
    {
        Movie existringMovie=movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found with Id"+id));

        existringMovie.setTitle(movie.getTitle());
        existringMovie.setGenre(movie.getGenre());
        existringMovie.setLanguage(movie.getLanguage());
        existringMovie.setRating(movie.getRating());

        return movieRepository.save(existringMovie);

    }

}
