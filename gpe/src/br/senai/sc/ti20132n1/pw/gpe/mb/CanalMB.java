package br.senai.sc.ti20132n1.pw.gpe.mb;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import br.senai.sc.ti20132n1.pw.gpe.dao.CanalDao;
import br.senai.sc.ti20132n1.pw.gpe.dao.TipoCanalDao;
import br.senai.sc.ti20132n1.pw.gpe.entity.Canal;
import br.senai.sc.ti20132n1.pw.gpe.entity.TipoCanal;
import br.senai.sc.ti20132n1.pw.gpe.util.UploadImageException;
import br.senai.sc.ti20132n1.pw.gpe.util.UploadImageUtil;

@ManagedBean
public class CanalMB {
	private Canal canal;
	private List<Canal> canais;
	private List<TipoCanal> tipos;
	private CanalDao canalDao;
	private Part logo;
	private UploadImageUtil uploadImageUtil;
	
	@PostConstruct
	public void initMB() {
		this.canal = new Canal();
		canalDao = new CanalDao();
		uploadImageUtil = new UploadImageUtil("img/uploads/");
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

	public Part getLogo() {
		return logo;
	}

	public void setLogo(Part logo) {
		this.logo = logo;
	}

	public String caminhoUpload(String imagem){
		return uploadImageUtil.getCaminhoRelativo(imagem);
	}
	
	public String salvar(){
		String nomeLogo;
		try {
			nomeLogo = uploadImageUtil.salvar(logo, canal.getLogo());
			canal.setLogo(nomeLogo);
		} catch (UploadImageException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não foi possivel salvar a imagem."));
			e.printStackTrace();
			return "";
		}
		
		canalDao.salvar(canal);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
		return "listacanal";
	}
	
	public String excluir(String idParam){
		Long id = Long.valueOf(idParam);
		
		Canal canalExcluir = canalDao.buscarPorId(id);
		uploadImageUtil.excluir(canalExcluir.getLogo());
		
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
