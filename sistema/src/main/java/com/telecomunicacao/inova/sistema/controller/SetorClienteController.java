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
import com.telecomunicacao.inova.sistema.modal.SetorCliente;
import com.telecomunicacao.inova.sistema.modal.Unidade;
import com.telecomunicacao.inova.sistema.service.SetorClienteDAO;
import com.telecomunicacao.inova.sistema.service.UnidadeDAO;

@Controller
@RequestMapping("/setorClientes")
public class SetorClienteController {
	private static String TAG = "/setorCliente";
	
	@Autowired
	SetorClienteDAO<SetorCliente> setorClienteDao;
	
	@Autowired
	UnidadeDAO<Unidade> unidadeDao;
	
	@RequestMapping
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
	@RequestMapping("/novo/{codigo}")
	public ModelAndView novo(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("cadastroSetorCliente");
		Unidade unidade = new Unidade();
		SetorCliente setorCliente = new SetorCliente();
		unidade.setCodigo(codigo);
		setorCliente.setUnidade(unidade);
		mv.addObject(setorCliente);
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
	@RequestMapping(value="/salvar/{codigo}")
	public String salvar(SetorCliente setorCliente, RedirectAttributes attributes, @PathVariable Long codigo) {
		Unidade unidade = new Unidade();
		unidade.setCodigo(codigo);
		setorCliente.setUnidade(unidade);
		try {
			if(setorCliente.getCodigo() == null) {
				setorClienteDao.salvar(SetorCliente.class, setorCliente, TAG);
				attributes.addFlashAttribute("mensagem", "Setor " + setorCliente.getNome() + " salvo com sucesso!");
			}else {
				setorClienteDao.atualizar(SetorCliente.class, setorCliente, TAG);
				attributes.addFlashAttribute("mensagem", "Setor " + setorCliente.getNome() + " atualizado com sucesso!");
			}
			return "redirect:/clientes/verCliente/"+setorCliente.getUnidade().getCodigo();
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		try {
			setorClienteDao.excluir(codigo, TAG);
			attributes.addFlashAttribute("mensagem","Setor excluído com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("mensagemErro","Erro ao excluir setor!");
		}
		return "redirect:/setorClientes";
	}
	// metodo para montar o combo dinamicamente
		@ModelAttribute("listaUnidades")
		public List<Unidade> listaUnidade() {
			List<Unidade> unidades = unidadeDao.listAll();
			return unidades;
		}
}
