package com.sistema.financeiro.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class FacesMessagesUtil {
	
	public static void adicionarMensagem(Severity severidade, String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
		severidade, mensagem, mensagem));
	}

}
