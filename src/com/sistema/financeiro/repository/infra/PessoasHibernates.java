package com.sistema.financeiro.repository.infra;

import java.util.List;

import org.hibernate.Session;

import com.sistema.financeiro.model.Pessoa;
import com.sistema.financeiro.repository.Pessoas;

public class PessoasHibernates implements Pessoas{
	
	private Session session;
	
	public PessoasHibernates(Session session) {
		this.session = session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> buscarTodasPessoas() {
		
		return this.session.createCriteria(Pessoa.class).list();
	}

	@Override
	public Pessoa buscarPorCodigo(Integer codigo) {
		
		return (Pessoa) this.session.get(Pessoa.class, codigo);
	}

	@Override
	public Pessoa cadastrar(Pessoa pessoa) {
		return (Pessoa) this.session.merge(pessoa);
	}
}
