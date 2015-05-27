package br.senai.sc.ti20132n1.pw.gpe.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.senai.sc.ti20132n1.pw.gpe.dao.CanalDao;
import br.senai.sc.ti20132n1.pw.gpe.dao.TipoCanalDao;
import br.senai.sc.ti20132n1.pw.gpe.entity.Canal;
import br.senai.sc.ti20132n1.pw.gpe.entity.TipoCanal;

@ManagedBean
public class CanalMB {
	private Canal canal;
	private List<Canal> canais;
	private List<TipoCanal> tipos;
	private CanalDao canalDao;
	
	@PostConstruct
	public void initMB() {
		this.canal = new Canal();
		canalDao = new CanalDao();
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	
	public List<Canal> getCanais() {
		if(canais == null){
			canais = canalDao.listarTodos();
		}
		return canais;
	}

	public void setCanais(List<Canal> canais) {
		this.canais = canais;
	}

	public List<TipoCanal> getTipos() {
		if(tipos == null){
			TipoCanalDao tipoCanalDao = new TipoCanalDao();
			tipos = tipoCanalDao.listarTodos();
		}
		return tipos;
	}

	public void setTipos(List<TipoCanal> tipos) {
		this.tipos = tipos;
	}

	public String salvar(){
		canalDao.salvar(canal);
		return "listacanal?faces-redirect=true";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		canalDao.excluir(id);
		canais = null;
		return "";
	}
	
	public String editar(String idParam){
		Long id = Long.valueOf(idParam);
		canal = canalDao.buscarPorId(id);
		return "formcanal";
	}
	
}
