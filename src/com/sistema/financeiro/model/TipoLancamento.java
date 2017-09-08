package com.sistema.financeiro.model;

public enum TipoLancamento {
	
	RECEITA("Receita"),
	DESPERSA("Despesa");
	
	private String descricao;
	
	private TipoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
