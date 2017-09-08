package com.sistema.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ConsultaLancamentoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<String> lancamentos = new ArrayList<String>();
	
	@PostConstruct
	public void inicializar(){
		for(int i = 0; i < 20; i++){
			this.lancamentos.add("");
		}
	}

	public List<String> getLancamentos() {
		return lancamentos;
	}
	

}
