package br.senai.sc.ti20132n1.pw.introjpa;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.type.TrueFalseType;

import br.senai.sc.ti20132n1.pw.introjpa.entity.Pessoa;
import br.senai.sc.ti20132n1.pw.introjpa.entity.Turma;

public class Main {
	public static EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("introJpaPu");

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

//		 inserir(entityManager);
//		inserirSomentePessoa(entityManager);
		// buscarPorId(entityManager);
		// excluir(entityManager);
//		 atualizar(entityManager);
//		listar(entityManager);
		listarTurmas(entityManager);
//		excluirTurma(entityManager);

		entityManager.getTransaction().commit();
		entityManager.close();

		entityManagerFactory.close();

	}

	private static void excluirTurma(EntityManager entityManager) {
		Turma turma = entityManager.getReference(Turma.class, 1L);
		entityManager.remove(turma);
		
	}

	private static void listarTurmas(EntityManager entityManager) {
		Query query = entityManager.createQuery("From Turma", Turma.class);
		List<Turma> turmas = query.getResultList();
		
		for (Turma turma : turmas) {
			System.out.print("----- " + turma.getCurso());
			System.out.print(turma.getAno() + "/" + turma.getSemestre());
			System.out.println(" -----");
			for (Pessoa pessoa : turma.getAlunos()) {
				System.out.print("Nome: " + pessoa.getNome());
				System.out.println(", " + pessoa.getIdade() + " anos.");
			}
			System.out.println("-------------------------");
		}
		
	}

	private static void listar(EntityManager entityManager) {
		Query query = entityManager.createQuery("From Pessoa", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();

		for (Pessoa pessoa : pessoas) {
			System.out
					.println("-----------------------------------------------------");
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Idade: " + pessoa.getIdade());
			System.out.print("Turma: " + pessoa.getTurma().getCurso().concat("/"));
			System.out.println(pessoa.getTurma().getSemestre());
		}
		System.out
				.println("-----------------------------------------------------");
	}

	private static void atualizar(EntityManager entityManager) {
		// Pessoa pessoa = entityManager.find(Pessoa.class, 3L);
		Pessoa pessoa;
		pessoa = new Pessoa();
		pessoa.setId(6L);
		pessoa.setIdade(25);
		pessoa.setNome("Nestor");
		pessoa.setSexo('M');

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

	private static void inserir(EntityManager entityManager) {
		Turma turma = new Turma();
		turma.setAno(2015);
		turma.setSemestre(1);
		turma.setCurso("TI");
		
		Pessoa pessoa;
		pessoa = new Pessoa();
		// pessoa.setId(1L);
		pessoa.setIdade(18);
		pessoa.setNome("Maria");
		pessoa.setSexo('F');
		pessoa.setTurma(turma );
		entityManager.persist(pessoa);
	}

	private static void inserirSomentePessoa(EntityManager entityManager) {
		Turma turma = entityManager.getReference(Turma.class, 1L);
		Pessoa pessoa;
		pessoa = new Pessoa();
		// pessoa.setId(1L);
		pessoa.setIdade(18);
		pessoa.setNome("Maria");
		pessoa.setSexo('F');
		pessoa.setTurma(turma);
		entityManager.persist(pessoa);
		
	}
	
	
}
