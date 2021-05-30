package com.thiagovcosta.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagovcosta.movieflix.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
