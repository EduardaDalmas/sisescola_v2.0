package br.com.ienh.sisescola.entidades;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="disciplina")
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String codigo;
	@ManyToMany
	@JoinTable(name = "disciplina_turma",
			   joinColumns = @JoinColumn(name="disciplina_id"),
			   inverseJoinColumns = @JoinColumn(name="turma_id"))
	private List<Turma> turmas;
	@ManyToMany
	@JoinTable(name = "curso_disciplina",
			   joinColumns = @JoinColumn(name="disciplina_id"),
			   inverseJoinColumns = @JoinColumn(name="curso_id"))
	private List<Curso> cursos;
	
	public Disciplina() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
