package com.marioecheverria.backend.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marioecheverria.backend.entity.Encuesta;
import com.marioecheverria.backend.repo.IEncuestRepo;
import com.marioecheverria.backend.service.IEncuestaService;

@Service
public class EncuestaServiceImpl implements IEncuestaService{

	@Autowired
	private IEncuestRepo encuestRepo;
	
	@Override
	public Encuesta save(Encuesta encuesta) {
		// TODO Auto-generated method stub
		return encuestRepo.save(encuesta);
	}

	@Override
	public List<Encuesta> findAll() {
		// TODO Auto-generated method stub
		return encuestRepo.findAll();
	}

}
