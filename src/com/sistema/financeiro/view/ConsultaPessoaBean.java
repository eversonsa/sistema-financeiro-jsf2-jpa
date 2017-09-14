package com.sistema.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sistema.financeiro.model.Pessoa;
import com.sistema.financeiro.repository.Pessoas;
import com.sistema.financeiro.util.Repositorios;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ConsultaPessoaBean implements Serializable{
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Repositorios repositorios = new Repositorios(); 
	@PostConstruct
	public void inicializar(){
		
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.buscarTodasPessoas();
		
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	
}
