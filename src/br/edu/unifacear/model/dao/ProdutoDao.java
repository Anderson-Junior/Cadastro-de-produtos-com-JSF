package br.edu.unifacear.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.unifacear.model.entity.Produto;
import br.edu.unifacear.util.Conexao;

public class ProdutoDao {
	public String salvar(Produto produto) throws Exception {
		String retorno = null;
		
		EntityManager em = Conexao.getEntityManager();

        try {
            em.getTransaction().begin();
            if (produto.getId() == null) {
                em.persist(produto);
                em.getTransaction().commit();
                return "Produto salvo";
            } else {
                em.merge(produto);
                em.getTransaction().commit();
                return "Produto atualizado";
            }
           
        } catch(Exception e) {
            throw new Exception(e.getMessage());
        }
	}
	
	public List<Produto> listar(){
		Query consulta = null;
		List<Produto> prod = null;
		
		EntityManager em = Conexao.getEntityManager();
		em.getTransaction().begin();
		
		consulta = em.createQuery("SELECT c FROM Produto c");
		
		prod = consulta.getResultList();
		
		em.getTransaction().commit();
		em.close();
		return prod;
	}
}
