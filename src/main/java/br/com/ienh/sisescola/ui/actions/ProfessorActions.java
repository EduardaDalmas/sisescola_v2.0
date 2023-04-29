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
		
	}

	public void remover() {
		
	}

	public void buscarPorId() {
		
	}
	
	public void buscarTodos() {
		
		try {	
			System.out.println();
			
			List<Professor> professores = professorDAO.findAll();
			
			if(professores.size() == 0) {
				System.out.println("NÃO HÁ PROFESSORES PARA MOSTRAR!");
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
