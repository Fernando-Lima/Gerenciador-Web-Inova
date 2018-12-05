package com.telecomunicacao.inova.sistema.controller;

import java.util.Arrays;
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
import com.telecomunicacao.inova.sistema.modal.Cliente;
import com.telecomunicacao.inova.sistema.modal.Situacao;
import com.telecomunicacao.inova.sistema.service.ClienteDAO;
import com.telecomunicacao.inova.sistema.service.CidadeDAO;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private static final String TAG = "/cliente";

	@Autowired
	ClienteDAO<Cliente> clienteDao;

	@Autowired
	CidadeDAO<Cidade> cidadeDao;

	//Listar
	@RequestMapping
	public ModelAndView listar() {
		ModelAndView mv;
		try {
			List<Cliente> clientes = clienteDao.listAll();
			mv = new ModelAndView("PesquisaClientes");
			mv.addObject("listaClientes", clientes);
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("404");
		}
		return mv;
	}

	//novo
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("cadastroCliente");
		mv.addObject(new Cliente());
		return mv;
	}

	//salvar
	@RequestMapping("/salvar")
	public String salvar(Cliente cliente, RedirectAttributes attributes) {
		try {
			if (cliente.getCodigo() == null) {
				clienteDao.salvar(Cliente.class, cliente, TAG);
				attributes.addFlashAttribute("mensagem", "Cliente " + cliente.getNome() + " salvo com sucesso!");
				System.out.println("cliente salvo>> " + cliente);
			}else {
				clienteDao.atualizar(Cliente.class, cliente, TAG);
				
				attributes.addFlashAttribute("mensagem", "Cliente " + cliente.getNome() + " atualizado com sucesso!");
				System.out.println("cliente atualizado >> " + cliente);
			}
			return "redirect:/clientes/novo";
		} catch (Exception e) {
			e.printStackTrace();
			return "404";
		}
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView buscarPorId(@PathVariable Long codigo) {
		ModelAndView mv = new ModelAndView("cadastroCliente");
		Cliente cliente = clienteDao.buscar(Cliente.class, codigo, TAG);
		mv.addObject(cliente);
		return mv;
	}
	
	@RequestMapping(value = "{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		try {
			clienteDao.excluir(codigo, TAG);
			attributes.addFlashAttribute("mensagem", "Cliente excluído com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("mensagemErro", "Erro ao excluir cliente");
		}
		return "redirect:/clientes";
	}

	// metodo para montar o combo dinamicamente
	@ModelAttribute("listaCidade")
	public List<Cidade> listaCidade() {
		List<Cidade> cidades = cidadeDao.listAll();
		return cidades;
	}

	@ModelAttribute("listaSituacao")
	public List<Situacao> listaSituacao() {
		return Arrays.asList(Situacao.values());
	}
}
