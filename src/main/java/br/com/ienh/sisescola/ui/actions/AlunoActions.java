package br.com.ienh.sisescola.ui.actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.ienh.sisescola.dao.AlunoDAO;
import br.com.ienh.sisescola.entidades.Aluno;
import br.com.ienh.sisescola.uteis.UserInput;

public class AlunoActions {
	
	private UserInput userInput;
	private AlunoDAO alunoDAO;
	
	public AlunoActions() {
		
		try {
			userInput = new UserInput();
			alunoDAO = new AlunoDAO();
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema no acesso a base de dados!");
		}
		
	}
	
	public void inserir() {
		
		try {
			Aluno aluno = new Aluno();
			
			System.out.println();
			
			System.out.println("Informe os dados de um novo aluno:");
			aluno.setNome(userInput.readText("Nome:"));
			aluno.setNumeroMatricula(userInput.readText("Número de matrícula:"));
			aluno.setEndereco(userInput.readText("Endereço:"));
			aluno.setNascimento(LocalDate.parse(userInput.readText("Data de Nascimento (aaaa-mm-dd):"), 
												DateTimeFormatter.ISO_DATE));
			aluno.setCpf(userInput.readText("CPF:"));
			
			alunoDAO.insert(aluno);
			
			System.out.println();
			System.out.println("Aluno registrado com sucesso!");
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar registrar o aluno! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void atualizar() {
		
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id do aluno que deseja atualizar:");
			
			Aluno aluno = alunoDAO.findById(id);
			
			if(aluno == null) {
				System.out.println("Aluno não encontrado!");
			}else {
				System.out.println("Informe os novos dados do aluno:");
				
				aluno.setNome(userInput.readText("Nome:"));
				aluno.setNumeroMatricula(userInput.readText("Número de matrícula:"));
				aluno.setEndereco(userInput.readText("Endereço:"));
				aluno.setNascimento(LocalDate.parse(userInput.readText("Data de Nascimento (aaaa-mm-dd):"), 
													DateTimeFormatter.ISO_DATE));
				aluno.setCpf(userInput.readText("CPF:"));
				
				alunoDAO.update(aluno);;
				
				System.out.println();
				System.out.println("Aluno atualizado com sucesso!");
			}
					
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar remover o aluno! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void remover() {
		
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id do aluno que deseja remover:");
			
			Aluno aluno = alunoDAO.findById(id);
			
			System.out.println();
			
			if(aluno == null) {
				System.out.println("Aluno não encontrado!");
			}else {
				alunoDAO.remove(aluno);
				System.out.println("Aluno removido com sucesso!");
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar remover o aluno! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void buscarPorId() {
		
		try {
			System.out.println();
	
			int id = userInput.readInt("Informe o id do aluno que deseja buscar:");
			
			Aluno aluno = alunoDAO.findById(id);
			
			System.out.println();
			
			if(aluno == null) {
				System.out.println("Aluno não encontrado!");
			}else {
				System.out.println("Dados do aluno: ");
				System.out.println(aluno.getId() + " - " + aluno.getNome() + " - " + aluno.getNumeroMatricula() + " - " + aluno.getNascimento());
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar o aluno! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void buscarTodos() {
		
		try {	
			System.out.println();
			
			List<Aluno> alunos = alunoDAO.findAll();
			
			System.out.println();
			
			if(alunos.size() == 0) {
				System.out.println("Não há alunos para visualizar!");
			}else {
				for (Aluno aluno : alunos) {
					System.out.println(aluno.getId() + " - " + aluno.getNome());
				}
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar os alunos! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

}
