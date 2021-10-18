package com.ingressos.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String movie;
	
	@Column(nullable = false)
	private String link;
	
	@Column(nullable = false)
	private String movieCover;
	
	@Column(nullable = false)
	private Float inteira;
	
	@Column(nullable = false)
	private Float meia;
	
	@Column(nullable = false)
	private Long userId;
	
	@Column(nullable = false)
	private String cinema;
	
	
	public String getCinema() {
		return cinema;
	}

	public void setCinemaId(String cinema) {
		this.cinema = cinema;
	}

	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getMovieCover() {
		return movieCover;
	}

	public void setMovieCover(String movieCover) {
		this.movieCover = movieCover;
	}

	public Float getInteira() {
		return inteira;
	}

	public void setInteira(Float inteira) {
		this.inteira = inteira;
	}

	public Float getMeia() {
		return meia;
	}

	public void setMeia(Float meia) {
		this.meia = meia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
