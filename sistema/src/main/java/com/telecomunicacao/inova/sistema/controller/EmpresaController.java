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
import com.telecomunicacao.inova.sistema.modal.Empresa;
import com.telecomunicacao.inova.sistema.service.CidadeDAO;
import com.telecomunicacao.inova.sistema.service.EmpresaDAO;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {
	private static final String TAG = "/unidade";

	@Autowired
	EmpresaDAO<Empresa> empresaDao;

	@Autowired
	CidadeDAO<Cidade> cidadeDao;

	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Empresa> empresas = empresaDao.listAll();
			mv = new ModelAndView("PesquisaEmpresas");
			mv.addObject("empresas", empresas);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroEmpresa");
		mv.addObject(new Empresa());
		return mv;
	}

	@RequestMapping("/salvar")
	public String salvar(Empresa empresa, RedirectAttributes attributes) {
		try {
			if (empresa.getCodigo() == null) {
				empresaDao.salvar(Empresa.class, empresa, TAG);
				attributes.addFlashAttribute("mensagem", "Empresa " + empresa.getNome() + " salva com sucesso!");
			} else {
				empresaDao.atualizar(Empresa.class, empresa, TAG);
				attributes.addFlashAttribute("mensagem", "Empresa " + empresa.getNome() + " atualizada com sucesso!");
			}
			return "redirect:/empresas/novo";
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("mensagemErro", "Erro ao salvar empresa " + empresa.getNome());
			return "redirect:/empresas/novo";
		}
	}
	
	//Buscar pelo ID
	@RequestMapping("{codigo}")
	public ModelAndView fundById(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("cadastroEmpresa");
		Empresa empresa = empresaDao.buscar(Empresa.class, codigo, TAG);
		mv.addObject(empresa);
		return mv;
	}

	@RequestMapping(value ="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		try {
			empresaDao.excluir(codigo, TAG);
			attributes.addFlashAttribute("mensagem", "Empresa excluída com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("mensagemErro", "erro ao excluir empresa!");
		}
		return "redirect:/empresas";
	}
	
	// metodo para montar o combo dinamicamente
	@ModelAttribute("listaCidade")
	public List<Cidade> listaCidade() {
		List<Cidade> cidades = cidadeDao.listAll();
		return cidades;
	}
}
