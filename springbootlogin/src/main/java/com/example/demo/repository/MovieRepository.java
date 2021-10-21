package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	@Query("SELECT p FROM Movie p WHERE CONCAT(p.movieTitle, ' ', p.movieYear, ' ', p.movieTime, ' ', p.movieLanguage,' ', p.movieReleasingCountry) LIKE %?1%")
	public List<Movie> search(String keyword);
}
