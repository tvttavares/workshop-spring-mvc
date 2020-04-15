package com.algaworks.cobranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.TitulosRepository;

@Service
public class TituloService {

	@Autowired
	private TitulosRepository titulos;

	public void salvar(Titulo titulo) {
		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data Invalido");
		}
	}

	public void excluir(Long codigo) {
		titulos.deleteById(codigo);
	}
}
