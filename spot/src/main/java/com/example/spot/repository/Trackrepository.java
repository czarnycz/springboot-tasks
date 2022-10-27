package com.example.spot.repository;

import com.example.spot.entity.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Trackrepository extends JpaRepository<Track,Long> {
}
