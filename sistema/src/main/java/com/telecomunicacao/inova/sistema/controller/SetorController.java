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

import com.telecomunicacao.inova.sistema.modal.Empresa;
import com.telecomunicacao.inova.sistema.modal.Setor;
import com.telecomunicacao.inova.sistema.service.EmpresaDAO;
import com.telecomunicacao.inova.sistema.service.SetorDAO;

@Controller
@RequestMapping("/setores")
public class SetorController {
	private static String TAG = "/setor";
	
	@Autowired
	SetorDAO<Setor> setorDao;
	
	@Autowired
	EmpresaDAO<Empresa> empresaDao;
	
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Setor> todosSetores = setorDao.listAll();
			mv = new ModelAndView("PesquisaSetor");
			mv.addObject("setores", todosSetores);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
	
	@RequestMapping("/novo")
	private ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroSetor");
		mv.addObject(new Setor());
		return mv;
	}
	
	//Buscar por id
	@RequestMapping("{codigo}")
	public ModelAndView findById(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("cadastroSetor");
		Setor setor = setorDao.buscar(Setor.class, codigo, TAG);
		mv.addObject(setor);
		return mv;
	}
	
	//Salvar
	@RequestMapping(value="/salvar")
	public String salvar(Setor setor, RedirectAttributes attributes) {
		try {
			if(setor.getCodigo() == null) {
				setorDao.salvar(Setor.class, setor, TAG);
				attributes.addFlashAttribute("mensagem", "Setor " + setor.getNome() + " salvo com sucesso!");
			}else {
				setorDao.atualizar(Setor.class, setor, TAG);
				attributes.addFlashAttribute("mensagem", "Setor " + setor.getNome() + " atualizado com sucesso");
			}
			return "redirect:/setores/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	//Excluir por id
	@RequestMapping(value="{codigo}", method=RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		try {
			setorDao.excluir(codigo, TAG);
			attributes.addFlashAttribute("mensagem", "Setor excluído com sucesso");
			return "redirect:/setores";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	//mota o combo dinamicamente
	@ModelAttribute("listaEmpresa")
	public List<Empresa> listarEmpresas(){
		List<Empresa> empresas =  empresaDao.listAll();
		return empresas;
	}
}
