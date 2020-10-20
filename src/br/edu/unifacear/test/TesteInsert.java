package br.edu.unifacear.test;

import br.edu.unifacear.controller.ProdutoController;
import br.edu.unifacear.model.entity.Produto;

public class TesteInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto produto = new Produto();
		
		produto.setNome("TV");
		produto.setCategoria("Eletronicos");
		produto.setCodigo(12345);
		produto.setDescricao("Sony Smart TV");
		produto.setPreco(4.000);
		
		//ProdutoDao dao = new ProdutoDao();
		//ProdutoBo bo = new ProdutoBo();
		ProdutoController prodControl = new ProdutoController();
		prodControl.setProduto(produto);
		try {
			prodControl.salvar();
			System.out.println("Produto salvo com sucesso");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
