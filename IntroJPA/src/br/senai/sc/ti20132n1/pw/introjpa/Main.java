package br.senai.sc.ti20132n1.pw.introjpa;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.senai.sc.ti20132n1.pw.introjpa.entity.Pessoa;

public class Main {
	public static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("introJpaPu");

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		 inserirNovo(entityManager);
		// buscarPorId(entityManager);
		// excluir(entityManager);
		// atualizar(entityManager);
		//listar(entityManager);

		entityManager.getTransaction().commit();
		entityManager.close();

		entityManagerFactory.close();

	}

	private static void listar(EntityManager entityManager) {
		Query query = entityManager.createQuery("From Pessoa", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();

		for (Pessoa pessoa : pessoas) {
			System.out
					.println("-----------------------------------------------------");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Idade: " + pessoa.getIdade());
		}
		System.out
				.println("-----------------------------------------------------");
	}

	private static void atualizar(EntityManager entityManager) {
		// Pessoa pessoa = entityManager.find(Pessoa.class, 3L);
		Pessoa pessoa;
		pessoa = new Pessoa();
		pessoa.setId(3L);
		pessoa.setIdade(25);
		pessoa.setNome("Nestor");
		pessoa.setSexo('F');

		entityManager.merge(pessoa);

		// entityManager.flush();
	}

	private static void excluir(EntityManager entityManager) {
		Pessoa pessoa = entityManager.getReference(Pessoa.class, 2L);
		entityManager.remove(pessoa);
	}

	private static void buscarPorId(EntityManager entityManager) {
		Pessoa pessoa = entityManager.find(Pessoa.class, 3L);
		System.out.println("Nome:" + pessoa.getNome());
		System.out.println("ID:" + pessoa.getId());
	}

	private static void inserirNovo(EntityManager entityManager) {
		Pessoa pessoa;
		pessoa = new Pessoa();
		// pessoa.setId(1L);
		pessoa.setIdade(18);
		pessoa.setNome("");
		pessoa.setSexo('F');
		entityManager.persist(pessoa);
	}
	
	
	
	
}
