package com.telecomunicacao.inova.sistema.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;
import com.telecomunicacao.inova.sistema.modal.Unidade;

@Service
public class UnidadeDAO<T extends MinhaEntidade> extends RestTemplateDAO<T> {
	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8081").build();
	
	public List<Unidade> listAll(){
		ResponseEntity<List<Unidade>> entity = restTemplate.exchange("/unidade", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Unidade>>() {
				});
		return entity.getBody();
	}
	public List<Unidade> listByCliente(Long codigo){
		ResponseEntity<List<Unidade>> entity = restTemplate.exchange("/unidade/cliente/"+codigo, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Unidade>>() {
				});
		return entity.getBody();
	}
	
}
