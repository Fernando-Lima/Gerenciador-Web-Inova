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

import com.telecomunicacao.inova.sistema.modal.Cliente;
import com.telecomunicacao.inova.sistema.modal.Unidade;
import com.telecomunicacao.inova.sistema.service.ClienteDAO;
import com.telecomunicacao.inova.sistema.service.UnidadeDAO;

@Controller
@RequestMapping("/unidades")
public class UnidadeController {
	private static final String TAG = "/unidade";

	@Autowired
	UnidadeDAO<Unidade> unidadeDao;

	@Autowired
	ClienteDAO<Cliente> clienteDao;

	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Unidade> unidades = unidadeDao.listAll();
			mv = new ModelAndView("PesquisaUnidades");
			mv.addObject("unidades", unidades);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroUnidade");
		mv.addObject(new Unidade());
		return mv;
	}

	@RequestMapping("/salvar")
	public String salvar(Unidade unidade, RedirectAttributes attributes) {
		try {
			if (unidade.getCodigo() == null) {
				unidadeDao.salvar(Unidade.class, unidade, TAG);
				attributes.addFlashAttribute("mensagem",unidade.getNome() + " salva com sucesso!");
			} else {
				unidadeDao.atualizar(Unidade.class, unidade, TAG);
				attributes.addFlashAttribute("mensagem", unidade.getNome() + " atualizada com sucesso!");
			}
			return "redirect:/unidades/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	//Buscar pelo ID
	@RequestMapping("{codigo}")
	public ModelAndView fundById(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("cadastroUnidade");
		Unidade unidade = unidadeDao.buscar(Unidade.class, codigo, TAG);
		mv.addObject(unidade);
		return mv;
	}

	@RequestMapping(value ="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		try {
			unidadeDao.excluir(codigo, TAG);
			attributes.addFlashAttribute("mensagem", "Unidade excluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("mensagemErro", "erro ao excluir unidade!");
		}
		return "redirect:/unidades";
	}
	
	// metodo para montar o combo dinamicamente
	@ModelAttribute("listaClientes")
	public List<Cliente> listaCliente() {
		List<Cliente> clientes = clienteDao.listAll();
		return clientes;
	}
}