package br.senai.sc.ti20132n1.pw.gpe.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.ti20132n1.pw.gpe.entity.Canal;

public class CanalDao extends Dao {

	public void salvar(Canal canal){
		getEntityManager().merge(canal);
	}

	@SuppressWarnings("unchecked")
	public List<Canal> listarTodos() {
		Query query = getEntityManager().createQuery("From Canal",Canal.class);
		return query.getResultList();
	}

	public void excluir(Long id) {
		Canal canal = getEntityManager().getReference(Canal.class, id);
		getEntityManager().remove(canal);
	}

	public Canal buscarPorId(Long id) {
		return getEntityManager().find(Canal.class, id);
	}
}
