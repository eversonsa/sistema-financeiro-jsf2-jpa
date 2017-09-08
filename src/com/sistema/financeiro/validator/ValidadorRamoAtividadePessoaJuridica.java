package com.sistema.financeiro.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sistema.financeiro.model.TipoPessoa;
import com.sun.faces.util.MessageFactory;

@FacesValidator("com.sistema.financeiro.ValidadorCondicionalPessoaJuridica")
public class ValidadorRamoAtividadePessoaJuridica implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
       TipoPessoa checadoPessoaJuridica =  (TipoPessoa) component.getAttributes().get("checadoPessoaJuridica");
		
		if(checadoPessoaJuridica != null && value == null){
			Object label = MessageFactory.getLabel(context, component);
			
			String descricaoErro = "Preencha o campo " + label + " .";
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
									descricaoErro, descricaoErro);
			throw new ValidatorException(message);
		}
	}

}
