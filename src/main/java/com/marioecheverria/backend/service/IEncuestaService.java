package com.marioecheverria.backend.service;

import java.util.List;

import com.marioecheverria.backend.entity.Encuesta;

public interface IEncuestaService {
	public Encuesta save(Encuesta encuesta);
	public List<Encuesta> findAll();
}
