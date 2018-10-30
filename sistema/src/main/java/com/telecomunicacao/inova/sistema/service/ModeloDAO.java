package com.telecomunicacao.inova.sistema.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;
import com.telecomunicacao.inova.sistema.modal.Modelo;

@Service
public class ModeloDAO<T extends MinhaEntidade> extends RestTemplateDAO<T> {
	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://aw-inova.cfapps.io").build();
	public List<Modelo> listAll(){
		ResponseEntity<List<Modelo>> entity = restTemplate.exchange("/modelo", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Modelo>>() {
				});
		return entity.getBody();
	}
	

}
