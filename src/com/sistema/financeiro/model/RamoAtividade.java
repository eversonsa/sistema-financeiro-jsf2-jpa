package com.sistema.financeiro.model;

import java.io.Serializable;

public class RamoAtividade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private String descricao;
	
	public RamoAtividade(){
	}
	
	public RamoAtividade(Integer codigo, String nome){
		this.codigo = codigo;
		this.descricao = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
