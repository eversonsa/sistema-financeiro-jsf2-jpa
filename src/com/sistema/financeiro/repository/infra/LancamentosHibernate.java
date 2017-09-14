package com.sistema.financeiro.repository.infra;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.sistema.financeiro.model.Lancamento;
import com.sistema.financeiro.repository.Lancamentos;

public class LancamentosHibernate implements Lancamentos{
	
	private Session session;
	
	public LancamentosHibernate(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lancamento> buscarTodosLancamentos() {
		
		return this.session.createCriteria(Lancamento.class).list();
	}

	@Override
	public Lancamento guardarLancamentos(Lancamento lancamento) {
		return (Lancamento) this.session.merge(lancamento);
	}

	@Override
	public void removerLancamentos(Lancamento lancamento) {
		this.session.delete(lancamento);		
	}

	@Override
	public Lancamento comDadosIguais(Lancamento lancamento) {
		return  (Lancamento) this.session.createCriteria(Lancamento.class)
				.add(Restrictions.eq("tipo", lancamento.getTipo()))
				.add(Restrictions.eq("pessoa", lancamento.getPessoa()))
				.add(Restrictions.ilike("descricao", lancamento.getDescricao()))
				.add(Restrictions.eq("valor", lancamento.getValor()))
				.add(Restrictions.eq("dataVencimento", lancamento.getDataVencimento()))
                .uniqueResult();
	}

}
