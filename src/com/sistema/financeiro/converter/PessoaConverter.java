package com.sistema.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sistema.financeiro.model.Pessoa;
import com.sistema.financeiro.service.GestaoPessoas;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa pessoa = null;
		if(value != null){
			GestaoPessoas gestaoPessoa = new GestaoPessoas();
			pessoa = gestaoPessoa.buscarPorCodigoID(new Integer(value));
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Pessoa) value).getCodigo().toString();
		}
		
		return null;
	}

}
