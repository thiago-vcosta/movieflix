package com.thiagovcosta.movieflix.dto;

import java.util.ArrayList;
import java.util.List;

import com.thiagovcosta.movieflix.entities.Genre;
import com.thiagovcosta.movieflix.entities.Movie;

public class GenreDTO {

	private Long id;
	private String name;

	private List<MovieDTO> movies = new ArrayList<>();

	public GenreDTO() {
	}

	public GenreDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public GenreDTO(Genre entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public GenreDTO(Genre entity, List<Movie> movies) {
		this(entity);
		movies.forEach(mov -> this.movies.add(new MovieDTO(mov)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieDTO> getMovies() {
		return movies;
	}

}
