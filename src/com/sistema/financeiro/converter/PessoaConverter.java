package com.sistema.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.sistema.financeiro.model.Pessoa;
import com.sistema.financeiro.util.FacesUtilFilter;

@FacesConverter(forClass=Pessoa.class)
public class PessoaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pessoa pessoa = null;
		
		if(value != null){
			Session session = (Session) FacesUtilFilter.getRequestAttribute("session");
			
			pessoa = (Pessoa) session.get(Pessoa.class, new Integer(value));
		}
		
		return pessoa;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Pessoa) value).getCodigo().toString();
		}
		
		return null;
	}

}
