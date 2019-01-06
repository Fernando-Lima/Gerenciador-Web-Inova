package com.telecomunicacao.inova.sistema.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;
import com.telecomunicacao.inova.sistema.modal.Setor;
import com.telecomunicacao.inova.sistema.modal.Unidade;

@Service
public class SetorDAO<T extends MinhaEntidade> extends RestTemplateDAO<T> {

	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8081").build();

	public List<Setor> listAll(){
		ResponseEntity<List<Setor>> entity = restTemplate.exchange("/setor", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Setor>>() {
				});
		return entity.getBody();
	}
}
