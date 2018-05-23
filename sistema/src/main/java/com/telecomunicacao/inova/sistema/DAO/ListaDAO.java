package com.telecomunicacao.inova.sistema.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecomunicacao.inova.sistema.modal.Lista;
import com.telecomunicacao.inova.sistema.repositorio.Listas;

@Service
public class ListaDAO {
	@Autowired
	private Listas listas;

	public void salvar(Lista lista) {
		try {
			listas.save(lista);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public List<Lista> listar(){
		return listas.findAll();
	}
}
