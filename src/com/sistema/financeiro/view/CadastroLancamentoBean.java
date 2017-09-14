package com.sistema.financeiro.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import com.sistema.financeiro.model.Lancamento;
import com.sistema.financeiro.model.Pessoa;
import com.sistema.financeiro.model.TipoLancamento;
import com.sistema.financeiro.repository.Lancamentos;
import com.sistema.financeiro.repository.Pessoas;
import com.sistema.financeiro.util.FacesMessagesUtil;
import com.sistema.financeiro.util.Repositorios;


@ManagedBean
@ViewScoped
public class CadastroLancamentoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();
	private Repositorios repositorios = new Repositorios();
	
	@PostConstruct
	public void init(){
		
		Pessoas pessoas = this.repositorios.getPessoas();
		this.pessoas = pessoas.buscarTodasPessoas();
		
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
    }
	
	public void cadastrar(){
		
		Lancamentos lancamentos = this.repositorios.getLancamentos();
		lancamentos.guardarLancamentos(lancamento);
		
		this.lancamento = new Lancamento();
		
		FacesMessagesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso");

	}
	
	
	public TipoLancamento[] getTipoLancamentos(){
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return this.lancamento;
	}
	
	public List<Pessoa> getPessoas(){
		return this.pessoas;
	}
	
	
}
