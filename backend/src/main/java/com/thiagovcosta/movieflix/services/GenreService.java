package com.thiagovcosta.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thiagovcosta.movieflix.dto.GenreDTO;
import com.thiagovcosta.movieflix.entities.Genre;
import com.thiagovcosta.movieflix.repositories.GenreRepository;
import com.thiagovcosta.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class GenreService {

	@Autowired
	GenreRepository repository;
	
	@Transactional(readOnly = true)
	public List<GenreDTO> findAll() {
		List<Genre> list = repository.findAll();		
		return list.stream().map(x -> new GenreDTO(x)).collect(Collectors.toList());				
		}
	
	@Transactional(readOnly = true)
	public GenreDTO findById(Long id) {
		Optional<Genre> obj = repository.findById(id);
		Genre entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
		return new GenreDTO(entity);
	}
}
