package com.telecomunicacao.inova.sistema.service;



import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;
import com.telecomunicacao.inova.sistema.modal.Uf;
@Service
public class UfDAO<T extends MinhaEntidade> extends RestTemplateDAO<T>{
	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8081").build();

	public List<Uf> listAll(){
		ResponseEntity<List<Uf>> entity = restTemplate.exchange("/uf", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Uf>>() {
				});
		return entity.getBody();
	}
	
}