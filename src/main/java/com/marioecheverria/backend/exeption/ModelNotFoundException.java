package com.marioecheverria.backend.exeption;

public class ModelNotFoundException extends RuntimeException {
	public ModelNotFoundException(String mensaje) {
		super(mensaje);
	}
}
