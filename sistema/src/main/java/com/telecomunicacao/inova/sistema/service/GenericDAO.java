package com.telecomunicacao.inova.sistema.service;


import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;

public interface GenericDAO<T extends MinhaEntidade>{
	void salvar(Class<T> classe,T entity, String url);
	void atualizar(Class<T> classe, T entity, String url);
	T buscar(Class<T> classe, Long codigo, String url);
}
