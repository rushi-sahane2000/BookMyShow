package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.ScreenRequest;
import com.cfs.BookMyShow.entity.Screen;
import com.cfs.BookMyShow.entity.Theater;
import com.cfs.BookMyShow.repository.ScreenRepository;
import com.cfs.BookMyShow.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreenService {
    private final ScreenRepository screenRepository;
    private final TheaterRepository theaterRepository;
    private final TheaterService theaterService;

    public Screen addScreen(ScreenRequest request) {

        // Step 1: Fetch Theater
        Theater theater = theaterRepository.findById(request.getTheaterID())
                .orElseThrow(() -> new RuntimeException("Theater not found"));

        // Step 2: Convert DTO -> Entity
        Screen screen = new Screen();
        screen.setName(request.getName());
        screen.setTotalSeats(request.getTotalSeats());
        screen.setTheater(theater);

        // Step 3: Save
        return screenRepository.save(screen);
    }

    public List<Screen> getAllScreen()
    {
        return  screenRepository.findAll();
    }

    public Screen getScreenById(Long id)
    {
        return  screenRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Screen not found with id "+id));
    }

    public List<Screen> getScreenByTheater(Long theaterId)
    {
        return screenRepository.findByTheaterId(theaterId);
    }


}
