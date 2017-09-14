package com.sistema.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.Session;

import com.sistema.financeiro.model.RamoAtividade;
import com.sistema.financeiro.util.FacesUtilFilter;

@FacesConverter(forClass=RamoAtividade.class)
public class RamoAtividadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		RamoAtividade ramoAtividade = null;
		if(value != null){
			
			Session session = (Session) FacesUtilFilter.getRequestAttribute("session");
			
			ramoAtividade = (RamoAtividade) session.get(RamoAtividade.class, new Integer(value));
		}
		return ramoAtividade;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
		 return ((RamoAtividade) value).getCodigo().toString();
		}
		
		return null;
	}

}
