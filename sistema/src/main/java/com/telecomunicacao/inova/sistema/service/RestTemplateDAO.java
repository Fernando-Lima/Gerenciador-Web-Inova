package com.telecomunicacao.inova.sistema.service;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;

public abstract class RestTemplateDAO<T extends MinhaEntidade> implements GenericDAO<T> {

	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://aw-inova.cfapps.io").build();

	private HttpHeaders createJSONHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}

	@Override
	public void salvar(Class<T>classe, T entity, String url) {
		restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(entity, createJSONHeader()), classe);
	}

	public void excluir(Long codigo, String url) {
		restTemplate.delete(url+"/{id}",codigo);
	}

	@Override
	public T buscar(Class<T> classe, Long codigo, String url) {
		// TODO Auto-generated method stub
		return restTemplate.getForObject(url+"/{id}", classe, codigo);
	}
	
	@Override
	public void atualizar(Class<T> classe, T entity, String url) {
		restTemplate.exchange(url+"/{id}",HttpMethod.PUT, new HttpEntity<>(entity,createJSONHeader()), classe, entity.getCodigo());
	}
}
