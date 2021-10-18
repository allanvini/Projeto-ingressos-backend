package com.ingressos.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ingressos.api.models.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
	List<Cinema> findAllByNameContains(String name);
}
