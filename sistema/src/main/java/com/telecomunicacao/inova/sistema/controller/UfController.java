package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.telecomunicacao.inova.sistema.modal.Uf;
import com.telecomunicacao.inova.sistema.service.ConectaWS;
import com.telecomunicacao.inova.sistema.service.UfDAO;

@Controller
@RequestMapping("/estados")
public class UfController {
	
	@Autowired
	ConectaWS conectaWS;
	
	@Autowired
	UfDAO<Uf> dao;
	
	//Listar estados
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Uf> estados = dao.listAll();
			mv = new ModelAndView("PesquisaEstados");
			System.out.println(estados);
			mv.addObject("estados", estados);
		} catch (Exception e) {
			mv = new ModelAndView("404");
		}
		return mv;
	}
	
	//Buscar estado pelo codigo
	@RequestMapping("{codigo}")
	public ModelAndView buscarPorId(@PathVariable("codigo") Long codigo) {
			ModelAndView mv = new ModelAndView("cadastroUf");
			Uf uf = dao.buscar(Uf.class, codigo);
			mv.addObject(uf);
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
		try {
			if(uf.getCodigo()== null) {
				dao.salvar(Uf.class,uf);
				attributes.addFlashAttribute("mensagem","Estado "+uf.getNome() +" salvo com sucesso!");
			}
			else {
				dao.atualizar(Uf.class, uf);
				attributes.addFlashAttribute("mensagem","Estado "+uf.getNome() +" atualizado com sucesso!");
			}
			return "redirect:/estados/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	//Deleta o objeto pelo ID
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		try {
			dao.excluir(codigo);
			attributes.addFlashAttribute("mensagem","Estado excluído com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/estados";
	}
}
