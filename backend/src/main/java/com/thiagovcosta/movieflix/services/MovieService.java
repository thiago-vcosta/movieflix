package com.thiagovcosta.movieflix.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thiagovcosta.movieflix.dto.MovieDTO;
import com.thiagovcosta.movieflix.entities.Movie;
import com.thiagovcosta.movieflix.repositories.MovieRepository;
import com.thiagovcosta.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {

	@Autowired
	MovieRepository repository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAllPaged(PageRequest pageRequest) {
		Page<Movie> list = repository.findAll(pageRequest);		
		return list.map(x -> new MovieDTO(x));				
		}
	
	@Transactional(readOnly = true)
	public MovieDTO findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new MovieDTO(entity);
	}
	
}
