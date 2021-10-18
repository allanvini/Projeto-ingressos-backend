package com.ingressos.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ingressos.api.models.Ticket;
import com.ingressos.api.repository.TicketRepository;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "http://localhost:3000")
public class TicketController {
	
	@Autowired
	private TicketRepository ticketRepository;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Ticket> listar() {
		return ticketRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Ticket adicionar(@RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	@GetMapping("/filter")
	@ResponseStatus(HttpStatus.OK)
	public List<Ticket> findTicketByMovie(@RequestParam("movie") String movie){
		return ticketRepository.findAllByMovieContains(movie);
	}
	
	@GetMapping("/mytickets")
	@ResponseStatus(HttpStatus.OK)
	public List<Ticket> findTicketByUser(@RequestParam("user") Long user){
		return ticketRepository.findByUserId(user);
	}
	
	@GetMapping("/edit")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Ticket> findTicketByID (@RequestParam("id") Long id ) {
		return ticketRepository.findById(id);
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteTicket(@RequestBody Ticket ticket) {
		ticketRepository.delete(ticket);
	}
	
	@PatchMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Ticket updateTicket(@RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
}
