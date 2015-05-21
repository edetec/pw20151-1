package br.senai.sc.ti20132n1.pw.gpe.dao;

import br.senai.sc.ti20132n1.pw.gpe.entity.Canal;

public class CanalDao extends Dao {

	public void salvar(Canal canal){
		getEntityManager().merge(canal);
	}
}
