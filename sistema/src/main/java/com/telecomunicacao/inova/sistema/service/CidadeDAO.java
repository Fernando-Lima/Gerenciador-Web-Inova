package com.telecomunicacao.inova.sistema.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.Cidade;
import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;

@Service
public class CidadeDAO<T extends MinhaEntidade> extends RestTemplateDAO<T> {

	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://aw-inova.cfapps.io").build();

	public List<Cidade> listAll(){
		ResponseEntity<List<Cidade>> entity = restTemplate.exchange("/cidade", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Cidade>>() {
				});
		return entity.getBody();
	}
}
