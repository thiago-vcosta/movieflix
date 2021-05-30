package com.thiagovcosta.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagovcosta.movieflix.entities.Genre;

@Repository
public interface GenreRepositoy extends JpaRepository<Genre, Long> {

}
