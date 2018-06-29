package com.telecomunicacao.inova.sistema.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;
import com.telecomunicacao.inova.sistema.modal.Uf;

public abstract class RestTemplateDAO<T extends MinhaEntidade> implements GenericDAO<T> {

	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://aw-inova.cfapps.io").build();

	private HttpHeaders createJSONHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}

	@Override
	public void salvar(T entity) {
		restTemplate.exchange("/uf", HttpMethod.POST, new HttpEntity<>(entity, createJSONHeader()), Uf.class);
	}

	@Override
	public void excluir(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public T buscar(Class<T> classe, Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> listar() {
		ResponseEntity<List<T>> entity = restTemplate.exchange("/uf", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<T>>() {
				});
		return entity.getBody();
		
	}
	public List<Uf> listAll(){
		ResponseEntity<List<Uf>> entity = restTemplate.exchange("/uf", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Uf>>() {
				});
		return entity.getBody();
	}
}
