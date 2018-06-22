package com.telecomunicacao.inova.sistema.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.modal.Uf;

@Controller
@RequestMapping("/estados")
public class UfController {
	RestTemplate restTemplate = new RestTemplateBuilder().rootUri("https://aw-inova.cfapps.io/uf").build();

	@RequestMapping
	public ModelAndView listar() {	

		// metogo get retorna um List com lista de obejo
		ResponseEntity<List<Uf>> estados = restTemplate.exchange("/",HttpMethod.GET, null,  
				new ParameterizedTypeReference<List<Uf>>() {
		});
		ModelAndView mv = new ModelAndView("PesquisaEstados");
		mv.addObject("estados", estados.getBody());
		System.out.println("// metogo get retorna um List com lista de obejo >>>  "+estados.getBody());
		return mv;
	}
}
