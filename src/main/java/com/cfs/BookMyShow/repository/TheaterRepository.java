package com.cfs.BookMyShow.repository;

import com.cfs.BookMyShow.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TheaterRepository  extends JpaRepository<Theater,Long> {
    List<Theater> findCityById(Long cityId);


}
