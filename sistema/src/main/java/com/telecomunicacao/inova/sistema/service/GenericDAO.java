package com.telecomunicacao.inova.sistema.service;


import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;

public interface GenericDAO<T extends MinhaEntidade>{
	void salvar(Class<T> classe,T entity);
	void atualizar(Class<T> classe, T entity);
	T buscar(Class<T> classe, Long codigo);
}
