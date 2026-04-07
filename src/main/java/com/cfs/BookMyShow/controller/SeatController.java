package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.dto.SeatRequest;
import com.cfs.BookMyShow.entity.Seat;
import com.cfs.BookMyShow.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatController {
        private final SeatService seatService;

        @PostMapping
        public ResponseEntity<Seat> addSeat(@RequestBody SeatRequest request)
        {
                return  ResponseEntity.ok(seatService.addSeat(request));
        }
        @GetMapping
        public ResponseEntity<List<Seat>> getAllSeats()
        {
                return  ResponseEntity.ok(seatService.getAllSeats());
        }

        @GetMapping("/{id}")
        public ResponseEntity<Seat> getSeatById(@PathVariable Long id)
        {
                return  ResponseEntity.ok(seatService.getSeatById(id));
        }

        @GetMapping("/screen/{screenId}")
        public ResponseEntity<List<Seat>> getSeatByScreenId(@PathVariable Long screenId)
        {
                return  ResponseEntity.ok(seatService.getSeatByScreenId(screenId));
        }
}
