package br.senai.sc.ti20132n1.pw.gpe.mb;

import javax.faces.bean.ManagedBean;

import br.senai.sc.ti20132n1.pw.gpe.dao.ContatoDao;
import br.senai.sc.ti20132n1.pw.gpe.entity.Contato;

@ManagedBean
public class ContatoMB {
	private Contato contato;
	
	public ContatoMB() {
		contato = new Contato();
	}
	
	public String enviar(){
		ContatoDao dao = new ContatoDao();
		dao.salvar(contato);
		contato = new Contato();
		return "";
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
}
