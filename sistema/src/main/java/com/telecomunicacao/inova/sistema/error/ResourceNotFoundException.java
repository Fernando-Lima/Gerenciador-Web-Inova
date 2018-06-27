package com.telecomunicacao.inova.sistema.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Não encontrado!")
public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException (String message) {
		super(message);
	}
}
