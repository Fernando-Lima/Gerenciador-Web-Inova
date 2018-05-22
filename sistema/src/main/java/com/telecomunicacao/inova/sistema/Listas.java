package com.telecomunicacao.inova.sistema;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telecomunicacao.inova.sistema.modal.Lista;

public interface Listas extends JpaRepository<Lista, Long>{

}
