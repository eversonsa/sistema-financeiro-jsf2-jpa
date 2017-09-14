package com.sistema.financeiro.util;

import java.io.Serializable;

import org.hibernate.Session;

import com.sistema.financeiro.repository.Lancamentos;
import com.sistema.financeiro.repository.Pessoas;
import com.sistema.financeiro.repository.RamosDeAtividades;
import com.sistema.financeiro.repository.infra.LancamentosHibernate;
import com.sistema.financeiro.repository.infra.PessoasHibernates;
import com.sistema.financeiro.repository.infra.RamoAtividadeHibernate;

@SuppressWarnings("serial")
public class Repositorios implements Serializable {
	
	public Pessoas getPessoas(){
		return new PessoasHibernates(this.getSession());
	}
	
	public Lancamentos getLancamentos(){
		return new LancamentosHibernate(this.getSession());
	}
	
	public RamosDeAtividades getAtividades(){
		return new RamoAtividadeHibernate(this.getSession());
	}
	
	private Session getSession(){
		return (Session) FacesUtilFilter.getRequestAttribute("session");
	}

}
