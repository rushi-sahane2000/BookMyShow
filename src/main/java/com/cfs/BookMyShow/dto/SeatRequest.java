package com.cfs.BookMyShow.dto;

import com.cfs.BookMyShow.enums.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SeatRequest {
    private String seatNumber;
    private String row;
    private String col;
    private SeatType seatType;
    private Long screenId;

}
