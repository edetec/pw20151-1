package br.senai.sc.ti20132n1.pw.gpe.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Canal {
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String logo;
	@ManyToOne
	private TipoCanal tipoCanal;
	
	public TipoCanal getTipoCanal() {
		return tipoCanal;
	}
	public void setTipoCanal(TipoCanal tipoCanal) {
		this.tipoCanal = tipoCanal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
}
