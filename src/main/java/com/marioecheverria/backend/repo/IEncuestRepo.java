package com.marioecheverria.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marioecheverria.backend.entity.Encuesta;

public interface IEncuestRepo extends JpaRepository<Encuesta, Long>{
	
}
