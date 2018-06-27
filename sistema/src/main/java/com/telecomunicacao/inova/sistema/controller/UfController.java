package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telecomunicacao.inova.sistema.error.Message;
import com.telecomunicacao.inova.sistema.modal.Uf;
import com.telecomunicacao.inova.sistema.service.ConectaWS;

@Controller
@RequestMapping("/estados")
public class UfController {
	
	@Autowired
	ConectaWS conectaWS;
	
	@RequestMapping
	public ModelAndView listar() {	
		 
		ModelAndView mv = new ModelAndView("PesquisaEstados");
		try {
			// metogo get retorna um List com lista de obejo
			ResponseEntity<List<Uf>> estados = conectaWS.getRestTemplate().exchange("/uf",HttpMethod.GET, null,  
					new ParameterizedTypeReference<List<Uf>>() {
			});
			mv.addObject("estados", estados.getBody());
		} catch (Exception e) {
			Message msg = new Message(404);
			String message = msg.getMessage();
			mv.addObject("mensagem", message);
		}
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView buscarPorId(@PathVariable("codigo") Long codigo) {	

		//metodo get retorna um objeto pelo codigo 
		Uf uf = conectaWS.getRestTemplate().getForObject("/uf/{id}", Uf.class, codigo);
		ModelAndView mv = new ModelAndView("PesquisaEstados");
		mv.addObject("estados", uf);
		System.out.println("// metogo get retorna um objeto >>>  "+uf);
		return mv;
	}
}
