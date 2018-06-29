package com.telecomunicacao.inova.sistema.service;



import org.springframework.stereotype.Service;

import com.telecomunicacao.inova.sistema.modal.MinhaEntidade;
@Service
public class UfDAO<T extends MinhaEntidade> extends RestTemplateDAO<T>{

}
