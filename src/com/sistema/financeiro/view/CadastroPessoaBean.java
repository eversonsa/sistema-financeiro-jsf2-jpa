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
import com.sistema.financeiro.repository.Pessoas;
import com.sistema.financeiro.repository.RamosDeAtividades;
import com.sistema.financeiro.util.FacesMessagesUtil;
import com.sistema.financeiro.util.Repositorios;

@ManagedBean
@ViewScoped
public class CadastroPessoaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Pessoa pessoa = new Pessoa();
	private List<RamoAtividade> ramoAtividades = new ArrayList<RamoAtividade>();
	private Repositorios repositorios = new Repositorios();
	
	@PostConstruct
	public void init(){
		
	   RamosDeAtividades  ramosAtividades = this.repositorios.getAtividades();
	   this.ramoAtividades = ramosAtividades.buscar();
		
	}
	
	public void tipoPessoaSelecionado(ValueChangeEvent event) {
		
		this.pessoa.setTipo((TipoPessoa) event.getNewValue());
		this.pessoa.setRamoAtividade(null);
		FacesContext.getCurrentInstance().renderResponse();
    }
	
	public void cadastrar(){
		
		Pessoas pessoas = this.repositorios.getPessoas();
		pessoas.cadastrar(pessoa);
		
		this.pessoa = new Pessoa();
		
		FacesMessagesUtil.adicionarMensagem(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso");

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
