package br.com.ienh.sisescola.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Column(name="numero_matricula")
	private String numeroMatricula;
	private String cpf;
	private String endereco;
	private LocalDate nascimento;
	@OneToMany(mappedBy = "aluno",
			   cascade={CascadeType.REMOVE})
	private List<Contato> contatos;
	@ManyToMany
	@JoinTable(name = "aluno_turma",
			   joinColumns = @JoinColumn(name="aluno_id"),
			   inverseJoinColumns = @JoinColumn(name="turma_id"))
	private List<Turma> turmas;
	@ManyToMany
	@JoinTable(name = "aluno_responsavel",
			   joinColumns = @JoinColumn(name="aluno_id"),
			   inverseJoinColumns = @JoinColumn(name="responsavel_id"))
	private List<Responsavel> responsaveis;
	
	public Aluno(){
		contatos = new ArrayList<Contato>();
		turmas = new ArrayList<Turma>();
		responsaveis = new ArrayList<Responsavel>();
	}

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

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
}
