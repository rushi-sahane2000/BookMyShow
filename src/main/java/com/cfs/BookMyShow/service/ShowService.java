package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.ShowRequest;
import com.cfs.BookMyShow.entity.Movie;
import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.entity.Show;
import com.cfs.BookMyShow.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowService {

    private final ShowRepository showRepository;
    private final MovieService movieService;
    private final ScreenService screenService;

    public Show addShow(ShowRequest request)
    {
        Movie movie=movieService.getMovieById(request.getMovieId());
        Screen screen=screenService.getScreenById(request.getScreenId());
        Show show=Show.builder()
                .movie(movie)
                .screen(screen)
                .showDate(request.getShowDate())
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .ticketPrice(request.getTicketPrice())
                .build();

        return  showRepository.save(show);
    }

    public List<Show> getAllShow()
    {
        return  showRepository.findAll();
    }

    public Show getShowById(Long id)
    {
        return  showRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Show not found by id "+id));
    }

    public List<Show> getShowByMovie(Long movieId)
    {
        return  showRepository.findByMovieId(movieId);
    }

    public List<Show> getShowByMovieDate(Long movieId, LocalDate localDate)
    {
        return  showRepository.findByMovieIdAndShowDate(movieId,localDate);
    }

    public List<Show> getShowByScreen(Long screenId)
    {
        return  showRepository.findByScreenId(screenId);
    }
}
