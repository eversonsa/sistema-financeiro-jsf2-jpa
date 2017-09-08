package com.sistema.financeiro.validator;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.sun.faces.util.MessageFactory;

@FacesValidator("dataFutura")
public class DataFutura implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
			
		    Date dataFutura = (Date) value;
		
		    if(dataFutura != null && dataFutura.after(new Date() )){
		    	Object label = MessageFactory.getLabel(context, component);
		    	String msg = label + " Não pode ser uma data futura";
		    	
		    	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						msg, msg);
	            throw new ValidatorException(message);
			}
	}

}
