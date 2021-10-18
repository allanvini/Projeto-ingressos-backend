package com.ingressos.api.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.ingressos.api.models.Cinema;
import com.ingressos.api.repository.CinemaRepository;

@RestController
@RequestMapping("/cinemas")
@CrossOrigin(origins = "http://localhost:3000")
public class CinemaController {
	
	@Autowired
	private CinemaRepository cinemaRepository;
	
	@GetMapping
	public List<Cinema> getCinemas(){
		return cinemaRepository.findAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Cinema createCinema(@RequestBody Cinema cinema) {
		return cinemaRepository.save(cinema);
	}
	
	@DeleteMapping("/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCinema(@RequestBody Cinema cinema) {
		cinemaRepository.delete(cinema);
	}
	
	@PatchMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Cinema updateCinema(@RequestBody Cinema cinema) {
		return cinemaRepository.save(cinema);
	}
	
	@GetMapping("/filter")
	@ResponseStatus(HttpStatus.OK)
	public List<Cinema> filterCinemas(@RequestParam("cinema") String cinema){
		return cinemaRepository.findAllByNameContains(cinema);
	}
	
}
