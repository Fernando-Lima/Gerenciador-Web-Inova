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
import com.telecomunicacao.inova.sistema.service.ModeloDAO;

@Controller
@RequestMapping("/modelos")
public class ModeloController {
	
	private static String TAG = "/modelo"; // Passa a url como parâmetro para os métodos DAO
	
	@Autowired
	ModeloDAO<Modelo> modeloDao;
	
	@RequestMapping
	public ModelAndView listarModelos() {
		ModelAndView mv;
		try {
			List<Modelo> modelos = modeloDao.listAll();
			mv = new ModelAndView("PesquisaModelos");
			mv.addObject("modelos", modelos);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroModelo");
		mv.addObject(new Modelo());
		return mv;
	}
	
	@RequestMapping( value = "/salvar")
	public String salvar(Modelo modelo, RedirectAttributes attributes) {
		try {
			if(modelo.getCodigo() == null) {
				modeloDao.salvar(Modelo.class, modelo, TAG);
				attributes.addFlashAttribute("mensagem","Estado "+modelo.getModelo() +" salvo com sucesso!");
			}else{
				modeloDao.atualizar(Modelo.class, modelo, TAG);
				attributes.addFlashAttribute("mensagem","Estado "+modelo.getModelo() +" atualizado com sucesso!");
			}
			return "redirect:/modelos/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		try {
			modeloDao.excluir(codigo, TAG);
			attributes.addFlashAttribute("mensagem","Modelo excluído com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("mensagemErro","Erro ao excluir o modelo ");
			
		}
		return "redirect:/modelos";
	}
	//Busca pelo codigo
	@RequestMapping(value="{codigo}")
	public ModelAndView buscarPorId(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("cadastroModelo");
		Modelo modelo = modeloDao.buscar(Modelo.class, codigo, TAG);
		mv.addObject(modelo);
		return mv;
	}
}
