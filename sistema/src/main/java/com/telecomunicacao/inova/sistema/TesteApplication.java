package com.telecomunicacao.inova.sistema;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.telecomunicacao.inova.sistema.modal.Uf;

public class TesteApplication {
	public static void main(String[] args) {
RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://aw-inova.cfapps.io/uf").build();
		
		//metodo get retorna um objeto com o codigo 2
		Uf uf = restTemplate.getForObject("/2", Uf.class);
		System.out.println("//metodo get retorna um objeto com o codigo 2 >>>  "+ uf);
		
		// metogo get retorna um array primitivo com lista de obejo
		Uf[] ufs = restTemplate.getForObject("/", Uf[].class);
		System.out.println("// metogo get retorna um array primitivo com lista de obejo >>>  "+ Arrays.toString(ufs));
		
		// metogo get retorna um List com lista de obejo
		ResponseEntity<List<Uf>> lista = restTemplate.exchange("/",HttpMethod.GET, null,  
				new ParameterizedTypeReference<List<Uf>>() {
		});
		System.out.println("// metogo get retorna um List com lista de obejo >>>  "+lista.getBody());
		
		Uf estado = new Uf();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		
		//motodo post passand objeto tipo Json
		ResponseEntity<Uf> ufPost = restTemplate.exchange("/",HttpMethod.POST, new HttpEntity<>(estado,createJSONHeader()), Uf.class);
		System.out.println("Metodo Post >>> " + ufPost);
		
		Uf estadoPost = restTemplate.postForObject("/", estado, Uf.class);
		System.out.println(estadoPost);
	}
	
	private static HttpHeaders createJSONHeader() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return httpHeaders;
	}
}
