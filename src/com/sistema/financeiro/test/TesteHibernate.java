package com.sistema.financeiro.test;

import java.util.List;

import org.hibernate.Session;

import com.sistema.financeiro.model.Pessoa;
import com.sistema.financeiro.util.HibernateUtil;

public class TesteHibernate {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = HibernateUtil.getSession();

		List<Pessoa> pessoa = session.createCriteria(Pessoa.class).list();

		for (Pessoa p : pessoa) {
			System.out.println(p.getTipo() + " - " + p.getNome() + " - " + p.getRamoAtividade().getDescricao() + " - " + p.getEmail()+ " - " +p.getDataNascimento());
		}

		session.close();
	}
}
