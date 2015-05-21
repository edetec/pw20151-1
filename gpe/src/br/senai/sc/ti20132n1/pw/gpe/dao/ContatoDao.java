package br.senai.sc.ti20132n1.pw.gpe.dao;

import br.senai.sc.ti20132n1.pw.gpe.entity.Contato;

public class ContatoDao extends Dao {
	public void salvar(Contato contato) {
		getEntityManager().merge(contato);
	}
}
