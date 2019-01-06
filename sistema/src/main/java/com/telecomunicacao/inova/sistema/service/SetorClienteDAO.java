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
import com.telecomunicacao.inova.sistema.modal.SetorCliente;

@Service
public class SetorClienteDAO<T extends MinhaEntidade> extends RestTemplateDAO<T> {

	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("http://localhost:8081").build();

	public List<SetorCliente> listAll(){
		ResponseEntity<List<SetorCliente>> entity = restTemplate.exchange("/setorCliente", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SetorCliente>>() {
				});
		return entity.getBody();
	}
	public List<SetorCliente> listByUnidade(Long codigo){
		ResponseEntity<List<SetorCliente>> entity = restTemplate.exchange("/setorCliente/unidade/"+codigo, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<SetorCliente>>() {
				});
		return entity.getBody();
	}
}
