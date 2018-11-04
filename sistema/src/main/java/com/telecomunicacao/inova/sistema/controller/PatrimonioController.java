package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.telecomunicacao.inova.sistema.modal.Modelo;
import com.telecomunicacao.inova.sistema.modal.Patrimonio;
import com.telecomunicacao.inova.sistema.service.ModeloDAO;
import com.telecomunicacao.inova.sistema.service.PatrimonioDAO;

@Controller
@RequestMapping("/patrimonios")
public class PatrimonioController {
	
	private static String TAG = "/produto";

	@Autowired
	PatrimonioDAO<Patrimonio> dao;

	@Autowired
	ModeloDAO<Modelo> modeloDao;

	@RequestMapping
	public ModelAndView listarPatrimonios() {
		ModelAndView mv;
		try {
			List<Patrimonio> todosPatrimonios = dao.listAll();
			mv = new ModelAndView("PesquisaPatrimonios");
			mv.addObject("patrimonios", todosPatrimonios);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv;
		mv = new ModelAndView("cadastroPatrimonio");
		mv.addObject(new Patrimonio());
		return mv;
	}

	// Metodo para montar o combo dinamicamente
	@ModelAttribute("listaModelo")
	public List<Modelo> listarModelos() {
		List<Modelo> modelos = modeloDao.listAll();
		return modelos;
	}
	
	@RequestMapping(value = "/salvar")
	public String salvar(Patrimonio patrimonio, RedirectAttributes attributes) {
		try {
			if(patrimonio.getCodigo() == null) {
				dao.salvar(Patrimonio.class, patrimonio, TAG);
				attributes.addFlashAttribute("mensagem","Patrimônio "+ patrimonio.getNome() +" salvo com sucesso!");
			}else {
				dao.atualizar(Patrimonio.class, patrimonio, TAG);
				attributes.addFlashAttribute("mensagem","Patrimonio "+patrimonio.getNome() +" atualizado com sucesso!");
			}
			return "redirect:/patrimonios/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	@RequestMapping(value="{codigo}", method=RequestMethod.DELETE)
	public String delete(@PathVariable Long codigo, RedirectAttributes attributes) {
		try {
			dao.excluir(codigo, TAG);
			attributes.addFlashAttribute("mensagem", "Patrimônio  escluído com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("mensagemErro", "Erro ao excluir patrimônio");
		}
		return "redirect:/patrimonios";
	}
	
	//Busca pelo codigo
	@RequestMapping(value="{codigo}")
	public ModelAndView findById(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("cadastroPatrimonio");
		Patrimonio patrimonio = dao.buscar(Patrimonio.class, codigo, TAG);
		mv.addObject(patrimonio);
		return mv;
	}
}