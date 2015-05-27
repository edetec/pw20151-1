package br.senai.sc.ti20132n1.pw.gpe.dao;

import java.util.List;

import javax.persistence.Query;

import br.senai.sc.ti20132n1.pw.gpe.entity.TipoCanal;

public class TipoCanalDao extends Dao {

	@SuppressWarnings("unchecked")
	public List<TipoCanal> listarTodos() {
		Query query = getEntityManager().createQuery("From TipoCanal",
				TipoCanal.class);
		return query.getResultList();
	}

	public TipoCanal buscaPorId(Long id) {
		return getEntityManager().getReference(TipoCanal.class, id);
	}
}
