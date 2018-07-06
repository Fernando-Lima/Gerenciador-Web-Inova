package com.telecomunicacao.inova.sistema.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.Cliente;
import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;

@Service
public class CLienteDAO<T extends MinhaEntidade> extends RestTemplateDAO<T>{

	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://aw-inova.cfapps.io").build();

	public List<Cliente> listAll(){
		ResponseEntity<List<Cliente>> entity = restTemplate.exchange("/cliente", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Cliente>>() {
				});
		return entity.getBody();
	}
}
