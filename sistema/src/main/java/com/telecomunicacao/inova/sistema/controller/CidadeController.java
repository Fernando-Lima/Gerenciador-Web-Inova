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

import com.telecomunicacao.inova.sistema.modal.Cidade;
import com.telecomunicacao.inova.sistema.modal.Uf;
import com.telecomunicacao.inova.sistema.service.CidadeDAO;
import com.telecomunicacao.inova.sistema.service.UfDAO;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

	private static String TAG = "/cidade";
	
	@Autowired
	CidadeDAO<Cidade> dao;
	
	@Autowired
	UfDAO<Uf> ufDao;
	
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Cidade> todasCidades = dao.listAll();
			mv  = new ModelAndView("PesquisaCidades");
			mv.addObject("cidades", todasCidades);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
	
	//Buscar pelo codigo
		@RequestMapping("{codigo}")
		public ModelAndView buscarPorId(@PathVariable("codigo") Long codigo) {
				ModelAndView mv = new ModelAndView("cadastroCidade");
				Cidade cidade = dao.buscar(Cidade.class, codigo, TAG);
				mv.addObject(cidade);
			return mv;
		}
		
		//Abrir tela de cadastro
		@RequestMapping("/novo")
		public ModelAndView novo() {
			ModelAndView mv = new ModelAndView("cadastroCidade");
			mv.addObject(new Uf());
			return mv;
		}
		
		//Salvando o objeto
		@RequestMapping(value="/salvar")
		public String salvar(Cidade cidade, RedirectAttributes attributes) {
			try {
				if(cidade.getCodigo()== null) {
					dao.salvar(Cidade.class,cidade, TAG);
					attributes.addFlashAttribute("mensagem","Cidade "+cidade.getNome() +" salvo com sucesso!");
				}
				else {
					dao.atualizar(Cidade.class, cidade, TAG);
					attributes.addFlashAttribute("mensagem","Cidade "+cidade.getNome() +" atualizado com sucesso!");
				}
				return "redirect:/cidades/novo";
			} catch (Exception e) {
				e.printStackTrace();
				return "404";
			}
		}
		
		//Deleta o objeto pelo ID
		@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
		public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
			try {
				dao.excluir(codigo, TAG);
				attributes.addFlashAttribute("mensagem","Cidade excluída com sucesso");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/cidades";
		}
		
		//metodo para montar o combo dinamicamente
		@ModelAttribute("listaUf")
		public List<Uf> listaUf(){
			List<Uf> estados = ufDao.listAll();
			return estados;
		}
}
