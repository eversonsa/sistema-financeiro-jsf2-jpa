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
import com.sistema.financeiro.repository.Lancamentos;
import com.sistema.financeiro.service.GestaoLancamentos;
import com.sistema.financeiro.service.RegraNegocioException;
import com.sistema.financeiro.util.FacesMessagesUtil;
import com.sistema.financeiro.util.FacesUtilFilter;
import com.sistema.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class ConsultaLancamentoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	private Lancamento lancamentoSelecionado;
	private Repositorios repositorios = new Repositorios();
	

	@PostConstruct
	public void inicializar(){
		
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		this.lancamentos = lancamentos.buscarTodosLancamentos();
	}
	
    public void excluir(){
		
    	GestaoLancamentos gestaoLancamentos = new GestaoLancamentos(this.repositorios.getLancamentos());
    	
    	try {
    		
			gestaoLancamentos.salvar(lancamentoSelecionado);
			
			FacesMessagesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Lancamento excluido com sucesso");
			
			this.inicializar();
			
		} catch (RegraNegocioException e) {
			
			FacesMessagesUtil.adicionarMensagem(FacesMessage.SEVERITY_ERROR, e.getMessage());
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
