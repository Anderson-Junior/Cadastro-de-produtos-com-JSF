package br.edu.unifacear.facades;

import br.edu.unifacear.model.bo.ProdutoBo;
import br.edu.unifacear.model.entity.Produto;

public class ProdutoFacade {
	private ProdutoBo produtoBo;
	
	
	public ProdutoFacade() {
		produtoBo = new ProdutoBo();
		
	}
	
	public void salvarProduto(Produto produto) throws Exception {
		produtoBo = new ProdutoBo();
		produtoBo.salvar(produto);
		
	}
	
	
}
