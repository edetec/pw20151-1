package br.senai.sc.ti20132n1.pw.gpe.mb;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class SessaoMB {
	private String usuario;
	private String senha;
	private String usuarioLogado;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isLogado(){
		return usuarioLogado != null;
	}
	
	public String login(){
		if(usuario.equalsIgnoreCase("admin") && senha.equals("1234")){
			usuarioLogado = usuario;
			return "/admin/listacanal?face-redirect=true";
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário ou senha inválido."));
		return "/login";
	}
	
	public String logout(){
		usuarioLogado = null;
		return "/index?face-redirect=true";
	}
}
