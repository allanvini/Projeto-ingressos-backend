package com.ingressos.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ingressos.api.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	List<Ticket>findAllByMovieContains(String movie);
	List<Ticket> findByUserId(Long userId);
	Optional<Ticket> findById(Long id);
}
