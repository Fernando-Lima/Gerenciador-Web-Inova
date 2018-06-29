package com.telecomunicacao.inova.sistema.service;

import java.util.List;

import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;

public interface GenericDAO<T extends MinhaEntidade>{
	void salvar(T entity);
	void excluir(T entity);
	T buscar(Class<T> classe, Long codigo);
	List<T> listar();
}
