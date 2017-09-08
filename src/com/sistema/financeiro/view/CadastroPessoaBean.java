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

import com.sistema.financeiro.model.Pessoa;
import com.sistema.financeiro.model.RamoAtividade;
import com.sistema.financeiro.model.TipoPessoa;
import com.sistema.financeiro.service.GestaoRamosAtividades;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa = new Pessoa();
	private List<RamoAtividade> ramoAtividades = new ArrayList<RamoAtividade>();
	
	@PostConstruct
	public void init(){
		GestaoRamosAtividades ramoAtividade = new GestaoRamosAtividades();
		this.ramoAtividades = ramoAtividade.buscarTodasAtividades();
	}
	
	public void tipoPessoaSelecionado(ValueChangeEvent event) {
		
		this.pessoa.setTipo((TipoPessoa) event.getNewValue());
		this.pessoa.setRamoAtividade(null);
		FacesContext.getCurrentInstance().renderResponse();
    }
	
	public void cadastrar(){
		System.out.println("Nome: " + this.pessoa.getNome());
		System.out.println("Tipo: " + this.pessoa.getTipo());
		System.out.println("Email: " + this.pessoa.getEmail());
		System.out.println("Data Nascimento: " + this.pessoa.getDataNascimento());
		if(this.pessoa.getRamoAtividade() == null){
			System.out.println("Ramo de Atividade: " + this.pessoa.getRamoAtividade());
		}else {
	     	System.out.println("Ramo de Atividade: " + this.pessoa.getRamoAtividade().getDescricao());
		}

		
		this.pessoa = new Pessoa();
		
		String mensagem = "Cadastro efetuado com sucesso";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
		FacesMessage.SEVERITY_INFO, mensagem, mensagem));

	}
	
	public void setRamoAtividades(List<RamoAtividade> ramoAtividades) {
		this.ramoAtividades = ramoAtividades;
	}

	public TipoPessoa[] getTipoPessoa(){
		return TipoPessoa.values();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public List<RamoAtividade> getRamoAtividades() {
		return ramoAtividades;
	}	
	
}
