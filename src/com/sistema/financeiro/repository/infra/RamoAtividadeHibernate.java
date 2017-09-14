package com.sistema.financeiro.repository.infra;

import java.util.List;

import org.hibernate.Session;

import com.sistema.financeiro.model.RamoAtividade;
import com.sistema.financeiro.repository.RamosDeAtividades;

public class RamoAtividadeHibernate implements RamosDeAtividades{
	
	private Session session;
	
	public RamoAtividadeHibernate(Session session) {
		this.session = session;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<RamoAtividade> buscar() {
		
		return this.session.createCriteria(RamoAtividade.class).list();
	}

}
