package com.cfs.BookMyShow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowRequest {

    private Long movieId;
    private Long screenId;
    private LocalDate showDate;
    private LocalTime showTime;
    private LocalTime endTime;
    private Double ticketPrice;
}
