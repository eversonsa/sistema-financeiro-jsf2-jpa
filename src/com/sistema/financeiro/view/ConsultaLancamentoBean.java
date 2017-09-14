package com.sistema.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.Session;

import com.sistema.financeiro.model.Lancamento;
import com.sistema.financeiro.util.FacesMessagesUtil;
import com.sistema.financeiro.util.FacesUtilFilter;

@ManagedBean
@ViewScoped
public class ConsultaLancamentoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void inicializar(){
		
		Session session = (Session) FacesUtilFilter.getRequestAttribute("session");
		
		this.lancamentos = session.createCriteria(Lancamento.class).list();
	}
	
    public void excluir(){
		
    	if(this.lancamentoSelecionado.isPago()){
    		FacesMessagesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Nao pode excluir lancamento pago");
    	}else {
    		Session session = (Session) FacesUtilFilter.getRequestAttribute("session");
			session.delete(this.lancamentoSelecionado);
			
			this.inicializar();
			
			FacesMessagesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "excluido com sucesso");
    	}
    	
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public Lancamento getLancamentoSelecionado() {
		return lancamentoSelecionado;
	}

	public void setLancamentoSelecionado(Lancamento lancamentoSelecionado) {
		this.lancamentoSelecionado = lancamentoSelecionado;
	}
	
	
}
