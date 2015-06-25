package br.senai.sc.ti20132n1.pw.gpe.mb;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.ti20132n1.pw.gpe.dao.UsuarioDao;
import br.senai.sc.ti20132n1.pw.gpe.entity.Usuario;

@ManagedBean(name="sessaoMB")
@SessionScoped
public class SessaoMB {

	private Usuario usuarioForm;
	private Usuario usuarioLogado;
	
	@PostConstruct
	public void init(){
		usuarioForm = new Usuario();
	}
	
	public boolean isLogado(){
		return usuarioLogado != null;
	}
	
	public String login(){
		UsuarioDao dao = new UsuarioDao();
		Usuario usuario = dao.buscaPonNome(usuarioForm.getNome());
		
		if(checkLogin(usuario)){
			usuarioLogado = usuario;
			return "/admin/listacanal?face-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha inválido."));
		return "/login";
	}
	
	private boolean checkLogin(Usuario usuarioEncontrado) {
		return usuarioEncontrado != null 
				&& usuarioForm.getNome().equalsIgnoreCase(usuarioEncontrado.getNome()) 
				&& usuarioForm.getSenha().equals(usuarioEncontrado.getSenha());
	}
	
	public String logout(){
		usuarioLogado = null;
		return "/index?face-redirect=true";
	}

	public Usuario getUsuarioForm() {
		return usuarioForm;
	}

	public void setUsuarioForm(Usuario usuarioForm) {
		this.usuarioForm = usuarioForm;
	}
}
