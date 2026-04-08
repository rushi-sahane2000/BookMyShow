package com.cfs.BookMyShow.dto;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
    private String title;
    private String description;
    private String genre;
    private String language;
    private Integer durationInMinutes;
    private Double rating;
    private LocalDate releaseDate;
    private String posterUrl;
}
