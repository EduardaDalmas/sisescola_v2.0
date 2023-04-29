package br.com.ienh.sisescola.entidades;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="turma")
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String semestre;
	@ManyToMany
	@JoinTable(name = "aluno_turma",
			   joinColumns = @JoinColumn(name="turma_id"),
			   inverseJoinColumns = @JoinColumn(name="aluno_id"))
	private List<Aluno> alunos;
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="professor_id")
	private Professor professor;
	@ManyToMany
	@JoinTable(name = "disciplina_turma",
			   joinColumns = @JoinColumn(name="turma_id"),
			   inverseJoinColumns = @JoinColumn(name="disciplina_id"))
	private List<Disciplina> disciplinas;
	
	public Turma() {
		alunos = new ArrayList<Aluno>();
		disciplinas = new ArrayList<Disciplina>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

}
