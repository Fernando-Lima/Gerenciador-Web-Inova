package com.telecomunicacao.inova.sistema.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.telecomunicacao.inova.sistema.modal.SetorCliente;
import com.telecomunicacao.inova.sistema.service.SetorClienteDAO;

@Controller
@RequestMapping("/setorCliente")
public class SetorClienteController {
	private static String TAG = "/setorCliente";
	
	@Autowired
	SetorClienteDAO<SetorCliente> setorClienteDao;
	
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<SetorCliente> listaSetorCliente = setorClienteDao.listAll();
			mv = new ModelAndView("PesquisaSetorCliente");
			mv.addObject("setorClientes", listaSetorCliente);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}
	//novo
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroSetorCliente");
		mv.addObject(new SetorCliente());
		return mv;
	}
	
	//buscarPorId
	@RequestMapping("{codigo}")
	public ModelAndView findById(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("cadastroSetorCliente");
		SetorCliente setorCliente = setorClienteDao.buscar(SetorCliente.class, codigo, TAG);
		mv.addObject(setorCliente);
		return mv;
	}
	
	//salvar
	@RequestMapping(value="/salvar")
	public String salvar(SetorCliente setorCliente, RedirectAttributes attributes) {
		try {
			if(setorCliente.getCodigo() == null) {
				setorClienteDao.salvar(SetorCliente.class, setorCliente, TAG);
				attributes.addFlashAttribute("mensagem", "Setor " + setorCliente.getNome() + " salvo com sucesso!");
			}else {
				setorClienteDao.atualizar(SetorCliente.class, setorCliente, TAG);
				attributes.addFlashAttribute("mensagem", "Setor " + setorCliente.getNome() + " atualizado com sucesso!");
			}
			return "redirect:/setorClientes/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
