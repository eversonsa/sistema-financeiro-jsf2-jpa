package com.sistema.financeiro.view;

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
import com.sistema.financeiro.service.GestaoPessoas;


@ManagedBean
@ViewScoped
public class CadastroLancamentoBean{
	
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();
	private Lancamento lancamento = new Lancamento();
	
	@PostConstruct
	public void init(){
		GestaoPessoas gestaoPessoa = new GestaoPessoas();
		this.pessoas = gestaoPessoa.listarTodasPessoas();
	}
	
	public void lancamentoPagoModificado(ValueChangeEvent event) {
		this.lancamento.setPago((Boolean) event.getNewValue());
		this.lancamento.setDataPagamento(null);
		FacesContext.getCurrentInstance().renderResponse();
    }
	
	public void cadastrar(){
		System.out.println("Tipo: " + this.lancamento.getTipo());
		System.out.println("Pessoa: " + this.lancamento.getPessoa().getNome());
		System.out.println("Descrição: " + this.lancamento.getDescricao());
		System.out.println("Valor: " + this.lancamento.getValor());
		System.out.println("Data vencimento: " + this.lancamento.getDataVencimento());
		System.out.println("Conta paga: " + this.lancamento.isPago());
		System.out.println("Data pagamento: " + this.lancamento.getDataPagamento());
		
		this.lancamento = new Lancamento();
		
		String mensagem = "Cadastro efetuado com sucesso";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
		FacesMessage.SEVERITY_INFO, mensagem, mensagem));

	}
	
	public TipoLancamento[] getTipoLancamento(){
		return TipoLancamento.values();
	}

	public Lancamento getLancamento() {
		return this.lancamento;
	}
	
	public List<Pessoa> getPessoas(){
		return this.pessoas;
	}
	
	
}
