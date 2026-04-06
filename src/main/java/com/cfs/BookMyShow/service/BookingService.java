package com.cfs.BookMyShow.service;

import com.cfs.BookMyShow.dto.BookingRequest;
import com.cfs.BookMyShow.entity.Booking;
import com.cfs.BookMyShow.entity.Seat;
import com.cfs.BookMyShow.entity.Show;
import com.cfs.BookMyShow.entity.User;
import com.cfs.BookMyShow.enums.BookingStatus;
import com.cfs.BookMyShow.repository.BookingRepository;
import com.cfs.BookMyShow.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private  final BookingRepository bookingRepository;
    private  final SeatRepository seatRepository;
    private  final UserService userService;
    private final ShowService showService;

    @Transactional
    public Booking createBooking(BookingRequest request)
    {
        User user =userService.getUserById(request.getUserId());
        Show show=showService.getShowById(request.getShowId());


        //check if any of the  requested seat are already booked

        List<Long> alreadyBookedSeats =bookingRepository.findBookedSeatIdsByShowId(show.getId());

        for (Long seatId:request.getSeatIds())
        {
            if (alreadyBookedSeats.contains(seatId))
            {
                throw new RuntimeException("Seat with id"+seatId+" is already Booked");
            }
        }

        List<Seat> seats=seatRepository.findAllById(request.getSeatIds());
        if(seats.size() !=request.getSeatIds().size())
        {
            throw new RuntimeException("Some Seats are Invalid");
        }

        double totalPrice= (int) (seats.size() * show.getTicketPrice());

        Booking booking=Booking.builder()
                .user(user)
                .show(show)
                .seats(seats)
                .totalPrice(totalPrice)
                .status(BookingStatus.CONFIRMED)
                .build();
        return  bookingRepository.save(booking);
    }

    public Booking getBookingById(Long bookingId)
    {
        return bookingRepository.findById(bookingId)
                .orElseThrow(()->new RuntimeException("Booking not found with id "+bookingId));
    }

    public List<Booking> getALlBookingByUser(Long userId)
    {
        return bookingRepository.findByUserId(userId);
    }

    public Booking cancelBooking(Long bookingId)
    {
        Booking booking=getBookingById(bookingId);
        booking.setStatus(BookingStatus.CANCELLED);

        return  bookingRepository.save(booking);
    }

    public List<Seat> getAvailableSeats(Long showId)
    {
        Show show=showService.getShowById(showId);
        List<Seat> allSeats=seatRepository.findByScreenId(show.getScreen().getId());
        List<Long> bookingSeatIds=bookingRepository.findBookedSeatIdsByShowId(showId);

        return  allSeats.stream()
                .filter(seat -> !bookingSeatIds.contains(seat.getId())).toList();
    }
}
