package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Movie;



public interface MovieService {
	
	List<Movie> getAllMovies();

	void saveMovie(Movie movie);

	Movie getMovieById(long id);

	void deleteMovieById(long id);
	
	 Page<Movie> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) ;
}
/*
 * public interface EmployeeService { List<Employee> getAllEmployees(); void
 * saveEmployee(Employee employee); Employee getEmployeeById(long id); void
 * deleteEmployeeById(long id); Page<Employee> findPaginated(int pageNo, int
 * pageSize, String sortField, String sortDirection); }
 */