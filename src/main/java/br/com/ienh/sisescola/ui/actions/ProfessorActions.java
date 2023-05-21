package br.com.ienh.sisescola.ui.actions;

import java.util.List;

import br.com.ienh.sisescola.dao.ProfessorDAO;
import br.com.ienh.sisescola.entidades.Professor;
import br.com.ienh.sisescola.uteis.UserInput;

public class ProfessorActions {

	private UserInput userInput;
	private ProfessorDAO professorDAO;
	
	public ProfessorActions() {

		try {
			userInput = new UserInput();
			professorDAO = new ProfessorDAO();
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema no acesso a base de dados!");
		}
	}
	
	public void inserir() {
		
		try {
			System.out.println();
			
			System.out.println("Informe os dados de um novo professor:");
			
			Professor professor = new Professor();
			professor.setNome(userInput.readText("Nome:"));
			
			professorDAO.insert(professor);
			
			System.out.println("Professor registrado com sucesso!");
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar registrar o professor! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void atualizar() {
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id do professor que deseja atualizar:");
			
			Professor professor = professorDAO.findById(id);
			
			if(professor == null) {
				System.out.println("professor não encontrado!");
			}else {
				System.out.println("Informe os novos dados do professor:");
				
				professor.setNome(userInput.readText("Nome:"));
				
				
				professorDAO.update(professor);;
				
				System.out.println();
				System.out.println("Professor atualizado com sucesso!");
			}
					
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar atualizar o professor! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}

	public void remover() {
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id do aluno que deseja remover:");
			
			Professor professor = professorDAO.findById(id);
			
			System.out.println();
			
			if(professor == null) {
				System.out.println("Professor não encontrado!");
			}else {
				professorDAO.remove(professor);
				System.out.println("Professor removido com sucesso!");
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar remover o professor! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}

	public void buscarPorId() {
		try {
			System.out.println();
	
			int id = userInput.readInt("Informe o id do professor que deseja buscar:");
			
			Professor professor = professorDAO.findById(id);
			
			System.out.println();
			
			if(professor == null) {
				System.out.println("professor não encontrado!");
			}else {
				System.out.println(professor.getId() + " - " + professor.getNome());
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar o professor! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}
	
	public void buscarTodos() {
		
		try {	
			System.out.println();
			
			List<Professor> professores = professorDAO.findAll();
			
			if(professores.size() == 0) {
				System.out.println("Não foram encontrados professores!");
			}else {
				for (Professor professor : professores) {
					System.out.println(professor.getId() + " - " + professor.getNome());
				}
			}
			
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar os professores! Entre em contato com o administrador!");
			e.printStackTrace();
		}
		
	}
	
}
