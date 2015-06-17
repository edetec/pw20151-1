package br.senai.sc.ti20132n1.pw.gpe.dao;

import javax.persistence.Query;

import br.senai.sc.ti20132n1.pw.gpe.entity.Usuario;

public class UsuarioDao extends Dao {
	public Usuario buscaPonNome(String nome) {
		Query query = getEntityManager().createQuery("From Usuario u Where u.nome = :nome", Usuario.class);
		query.setParameter("nome", nome);
		return (Usuario) query.getSingleResult();
	}
}
