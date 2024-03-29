package com.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.internal.NotNull;


@Entity
@Table(name = "Turma")
public class Turma  implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3132132385404193804L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idTurma")
    private Integer id;
	
	
	@Column(name="codigo")
	private String codigo;
	
	
	@Column(name="descricao")
	private String descricao;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idSemestre")
	private Semestre semestre;
	
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProfessor")
	private Professor professor;
	
	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idDisciplina")
	private Disciplina disciplina;

	@Column(name="inicioDeVigencia")
	@Temporal(TemporalType.DATE)
	private Date inicioDeVigencia;
	
	@Column(name="fimDeVigencia")
	@Temporal(TemporalType.DATE)
	private Date fimDeVigencia;
	
	@ManyToMany(mappedBy = "turmas")
	private Collection<Aluno> alunos;

	
	
	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Date getInicioDeVigencia() {
		return inicioDeVigencia;
	}

	public void setInicioDeVigencia(Date inicioDeVigencia) {
		this.inicioDeVigencia = inicioDeVigencia;
	}

	public Date getFimDeVigencia() {
		return fimDeVigencia;
	}

	public void setFimDeVigencia(Date fimDeVigencia) {
		this.fimDeVigencia = fimDeVigencia;
	}

	public Collection<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(Collection<Aluno> alunos) {
		this.alunos = alunos;
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	

}
