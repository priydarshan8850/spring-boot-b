package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String movieTitle;
	private Integer movieYear;
	private Integer movieTime;
	private String movieLanguage;
	private String movieReleasingDate;
	private String movieReleasingCountry;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "actor_id")
	Actor actor;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "director_id")
	Director director;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public Integer getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(Integer movieYear) {
		this.movieYear = movieYear;
	}

	public Integer getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(Integer movieTime) {
		this.movieTime = movieTime;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieReleasingDate() {
		return movieReleasingDate;
	}

	public void setMovieReleasingDate(String movieReleasingDate) {
		this.movieReleasingDate = movieReleasingDate;
	}

	public String getMovieReleasingCountry() {
		return movieReleasingCountry;
	}

	public void setMovieReleasingCountry(String movieReleasingCountry) {
		this.movieReleasingCountry = movieReleasingCountry;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

}
