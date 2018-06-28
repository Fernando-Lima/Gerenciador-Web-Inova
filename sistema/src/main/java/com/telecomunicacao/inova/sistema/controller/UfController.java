package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.telecomunicacao.inova.sistema.error.Message;
import com.telecomunicacao.inova.sistema.modal.Uf;
import com.telecomunicacao.inova.sistema.service.ConectaWS;

@Controller
@RequestMapping("/estados")
public class UfController {
	
	@Autowired
	ConectaWS conectaWS;
	
	//Listar estados
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			// metogo get retorna um List com lista de obejo
			ResponseEntity<List<Uf>> estados = conectaWS.getRestTemplate().exchange("/uf",HttpMethod.GET, null,  
					new ParameterizedTypeReference<List<Uf>>() {
			});
			mv = new ModelAndView("PesquisaEstados");
			mv.addObject("estados", estados.getBody());
		} catch (Exception e) {
//			Message msg = new Message(404);
//			String message = msg.getMessage();
//			mv.addObject("mensagem", "Servidor"+message);
			mv = new ModelAndView("404");
		}
		return mv;
	}
	
	//Buscar estado pelo codigo
	@RequestMapping("{codigo}")
	public ModelAndView buscarPorId(@PathVariable("codigo") Long codigo) {
			//metodo get retorna um objeto pelo codigo 
			ModelAndView mv = new ModelAndView("PesquisaEstados");
			Uf uf = conectaWS.getRestTemplate().getForObject("/uf/{id}", Uf.class, codigo);
			mv.addObject("estados", uf);
		return mv;
	}
	
	//Abrir tela de cadastro de estado
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroUf");
		mv.addObject(new Uf());
		return mv;
	}
	
	//Salvando o objeto
	@RequestMapping(value="/salvar")
	public String salvar(Uf uf, RedirectAttributes attributes) {
		System.out.println(uf);
		try {
			ResponseEntity<Uf> ufPost = conectaWS.getRestTemplate().exchange("/uf",HttpMethod.POST, new HttpEntity<>(uf,conectaWS.createJSONHeader()), Uf.class);
			attributes.addFlashAttribute("mensagem","Estado salvo com sucesso");
			return "redirect:/estados/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
}
