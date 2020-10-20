package br.edu.unifacear.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.edu.unifacear.facades.ProdutoFacade;
import br.edu.unifacear.model.bo.ProdutoBo;
import br.edu.unifacear.model.entity.Produto;

@ManagedBean(name="produtoBean")
@RequestScoped
public class ProdutoController {
	private Produto produto;
	private List<Produto> produtos;

	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoController() {
		produto = new Produto();
		this.produtos = new ArrayList();
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String inicial() {
		return "produto";
	}
	
	public String salvar() {
		
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			ProdutoFacade facade = new ProdutoFacade();
			facade.salvarProduto(this.produto);
			
		}
		catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"")); 
			return "";
		}
		
		  context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				  "Produto salvo com sucesso!", "")); 
				  return ""; 
	}
	public String novo() {
		return "produto";
	}	
	
	public String inicializar() {
		return "produto";
	}	
	
	@PostConstruct
	public void listar() {
		this.produtos = new ArrayList();
		
		for(Produto produto : new ProdutoBo().Listar()) {
			this.produtos.add(produto);
		}
	}
	
	public String index() {
		return "index";
	}
	
	public String bemvindo() {
		return "bemVindo";
	}
	
	public String lista() {
		return "listar";
	}
	
}
