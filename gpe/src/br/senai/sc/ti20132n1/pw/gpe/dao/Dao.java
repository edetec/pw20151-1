package br.senai.sc.ti20132n1.pw.gpe.dao;

import javax.persistence.EntityManager;

import br.senai.sc.ti20132n1.pw.gpe.util.JPAUtil;

public abstract class Dao {

	protected EntityManager getEntityManager() {
		return JPAUtil.getEntityManager();
	}

}