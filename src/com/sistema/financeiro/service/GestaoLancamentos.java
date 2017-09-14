package com.sistema.financeiro.service;

import com.sistema.financeiro.model.Lancamento;
import com.sistema.financeiro.repository.Lancamentos;

public class GestaoLancamentos {
	
	private Lancamentos lancamentos;
	
	public GestaoLancamentos(Lancamentos lancamentos) {
		this.lancamentos = lancamentos;
	}
	
	public void salvar(Lancamento lancamento) throws RegraNegocioException{
		
		if(existeLancamentoSemelhante(lancamento)){
				throw new RegraNegocioException("J� existe um lan�amento igual a este.");
		}
		this.lancamentos.guardarLancamentos(lancamento);
		
	}
	
	private boolean existeLancamentoSemelhante(Lancamento lancamento) {
		Lancamento lancamentoSemelhante = this.lancamentos.comDadosIguais(lancamento);
		
		return lancamentoSemelhante != null && !lancamentoSemelhante.equals(lancamento);
    }
	
	public void excluir(Lancamento lancamento) throws RegraNegocioException {
		if (lancamento.isPago()) {
			throw new RegraNegocioException("Lan�amento pago n�o pode ser exclu�do.");
		}
		
		this.lancamentos.removerLancamentos(lancamento);
}
}
