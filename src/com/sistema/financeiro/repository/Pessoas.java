package com.sistema.financeiro.repository;

import java.util.List;

import com.sistema.financeiro.model.Pessoa;

public interface Pessoas {
	

	public List<Pessoa> buscarTodasPessoas();
    public Pessoa buscarPorCodigo(Integer codigo);
    public Pessoa cadastrar(Pessoa pessoa);
    
}
