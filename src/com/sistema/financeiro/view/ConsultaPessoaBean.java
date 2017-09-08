package com.sistema.financeiro.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ConsultaPessoaBean {
	
	private List<String> pessoas = new ArrayList<String>();
	
	@PostConstruct
	public void inicializar(){
	for(int i = 0; i < 10; i++){
		pessoas.add("");
	 }
	}
	public List<String> getPessoas() {
		return pessoas;
	}
	
	
}
