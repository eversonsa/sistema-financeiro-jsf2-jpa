package com.sistema.financeiro.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sistema.financeiro.model.Pessoa;

public class GestaoPessoas {
	
	private static Map<Integer, Pessoa> pessoas = new HashMap<Integer, Pessoa>();
	
	static {
		pessoas.put(1, new Pessoa(1, "everson souza"));
		pessoas.put(2, new Pessoa(2, "Evana Kelvia"));
		pessoas.put(3, new Pessoa(3, "Jovem Pam"));
	}
	
	public List<Pessoa> listarTodasPessoas(){
		
		List<Pessoa> pessoa = new ArrayList<Pessoa>();
		pessoa.addAll(GestaoPessoas.pessoas.values());
		return pessoa;
	}
	
	public Pessoa buscarPorCodigoID(Integer codigo){
		return GestaoPessoas.pessoas.get(codigo);
	}
}
