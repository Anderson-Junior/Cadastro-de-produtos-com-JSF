package br.edu.unifacear.model.bo;

import java.util.List;

import br.edu.unifacear.model.dao.ProdutoDao;
import br.edu.unifacear.model.entity.Produto;

public class ProdutoBo {
	public String salvar(Produto produto)throws Exception {
		//VerificarDadosProduto(produto);
		//ProdutoDao dao = new ProdutoDao();
		try {
			return new ProdutoDao().salvar(produto);
		}
		catch(Exception e) {
			throw new Exception("nome do produto nao pode ser nulo");
		}
		
		
	}
	
	public void VerificarDadosProduto(Produto produto) throws Exception {

		if (produto.getId() < 0) {
			throw new Exception("ID NAO PODE SER NUMERO NEGATIVO");
		}
		if (produto.getNome().equals("")) {
			throw new Exception("NOME NAO PODE FICAR EM BRANCO");
		}
		
	}
	
	public List<Produto> Listar(){
		
		ProdutoDao dao = new ProdutoDao();
		return dao.listar();
	}
}
