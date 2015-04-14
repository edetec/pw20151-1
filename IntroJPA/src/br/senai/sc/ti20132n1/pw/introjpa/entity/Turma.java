package br.senai.sc.ti20132n1.pw.introjpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	@Id
	@GeneratedValue
	private Long id;
	private String curso;
	private Integer ano;
	private Integer semestre;
	
	@OneToMany(mappedBy="turma",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Pessoa> alunos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}
	public List<Pessoa> getAlunos() {
		return alunos;
	}
	public void setAlunos(List<Pessoa> alunos) {
		this.alunos = alunos;
	}	
}
