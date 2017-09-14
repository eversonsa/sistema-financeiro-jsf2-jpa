package com.sistema.financeiro.repository;

import java.util.List;

import com.sistema.financeiro.model.Lancamento;

public interface Lancamentos {
	
	public List<Lancamento> buscarTodosLancamentos();
	public Lancamento guardarLancamentos(Lancamento lancamento);
    public void removerLancamentos(Lancamento lancamento);
    
}
