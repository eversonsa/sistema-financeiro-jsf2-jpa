package com.sistema.financeiro.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.sistema.financeiro.model.RamoAtividade;
import com.sistema.financeiro.service.GestaoRamosAtividades;

@FacesConverter(forClass=RamoAtividade.class)
public class RamoAtividadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		RamoAtividade ramoAtividade = null;
		if(value != null){
			GestaoRamosAtividades gestaoRamoAtividade = new GestaoRamosAtividades();
			return ramoAtividade = gestaoRamoAtividade.buscarPorCodigoRamoAtividade(new Integer(value));
		}
		return ramoAtividade;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			//RamoAtividade ramoAtividade = (RamoAtividade) value;
			//return ramoAtividade.getCodigo().toString();
		 return ((RamoAtividade) value).getCodigo().toString();
		}
		
		return null;
	}

}
