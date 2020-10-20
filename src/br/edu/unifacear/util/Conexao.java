package br.edu.unifacear.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
private static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("Nome_Da_Unit_De_Persistencia");
	}	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}	
}
