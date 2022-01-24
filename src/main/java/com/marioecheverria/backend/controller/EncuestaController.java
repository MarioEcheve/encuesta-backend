package com.marioecheverria.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marioecheverria.backend.entity.Encuesta;
import com.marioecheverria.backend.reponse.Response;
import com.marioecheverria.backend.service.IEncuestaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/encuesta")
public class EncuestaController {

	@Autowired
	private IEncuestaService encuestaService;
	
	@PostMapping("/save")
	public ResponseEntity<Response> save(@RequestBody Encuesta request) {
		Response response = new Response();
		try {
			Encuesta encuesta = encuestaService.save(request);
			response.setData(encuesta);
			response.setStatus("success");
			response.setMessage(null);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}
		catch (DataIntegrityViolationException e) {
			response.setData(null);
			response.setStatus("failure");
			response.setMessage("El mail ya existe");
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch (Exception e) {
			response.setData(null);
			response.setStatus("failure");
			response.setMessage("Error al grabar en bd ");
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/findAll")
	public ResponseEntity<Response> findAll() {
		Response response = new Response();
		try {
			List<Encuesta> encuesta = encuestaService.findAll();
			response.setData(encuesta);
			response.setStatus("success");
			response.setMessage(null);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		}catch (Exception e) {
			response.setData(null);
			response.setStatus("failure");
			response.setMessage("Error Interno del servidor ");
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
