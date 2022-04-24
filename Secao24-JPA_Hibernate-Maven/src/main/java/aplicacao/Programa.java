package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		// Inclusão de novos registros
		/*Pessoa p1 = new Pessoa(null, "Alex Grey", "alex@gmail.com");
		Pessoa p2 = new Pessoa(null, "Maria Green", "maria@gmail.com");
		Pessoa p3 = new Pessoa(null, "Bob Brown", "bob@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();*/
		
		// Consulta de registros existentes
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);	// pesquisando no DB o registro conforme a classe pessoa contendo o ID = 2
		System.out.println(p);
		
		// Obrigatorio em inclusoes, alteraçoes e exclusoes adicionar a transação
		em.getTransaction().begin();
		em.remove(p); 	// Removendo um registro conforme o objeto. No JPA nao podemos indicar diretamento o registro e sim associar a exclusao a um regitro pesquisado anteriormente. Por isso o ideal é listar no banco montando o obj, depois deletar.
		em.getTransaction().commit();
		System.out.println("Registro removido");
		
		System.out.println("Finalizado");
		em.close();
		emf.close();
	}

}
