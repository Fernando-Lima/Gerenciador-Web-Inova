package com.telecomunicacao.inova.sistema.service;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.Uf;

@Service
public class ConectaWS {
	private RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://aw-inova.cfapps.io").build();
	
	
	private HttpHeaders createJSONHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}
	
	// verbo GET retorna um List com lista de obejo
	public List<Uf> listAll(){
		ResponseEntity<List<Uf>> estados = restTemplate.exchange("/uf",HttpMethod.GET, null,  
				new ParameterizedTypeReference<List<Uf>>() {
		});
		return estados.getBody();
	}
	
	//verbo GET retorna um objeto pelo codigo
	public Uf findById(Long codigo) {
		return restTemplate.getForObject("/uf/{id}", Uf.class, codigo);
	}
	
	//verbo POST salvar um objeto
	public void save(Uf uf) {
		restTemplate.exchange("/uf",HttpMethod.POST, new HttpEntity<>(uf,createJSONHeader()), Uf.class);
	}
	
	// verbo PUT atualizar um objeto
	public void update(Uf uf) {
		restTemplate.exchange("/uf/{id}",HttpMethod.PUT, new HttpEntity<>(uf,createJSONHeader()), Uf.class, uf.getCodigo());
	}
	
	//verbo DELETE para excluir um objeto pelo id
	public void delete(Long codigo) {
		restTemplate.delete("/uf/{id}",codigo);
	}
	
}
