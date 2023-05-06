package br.com.ienh.sisescola.ui.actions;

import br.com.ienh.sisescola.dao.AlunoDAO;
import br.com.ienh.sisescola.dao.ResponsavelDAO;
import br.com.ienh.sisescola.entidades.Aluno;
import br.com.ienh.sisescola.entidades.Responsavel;
import br.com.ienh.sisescola.uteis.UserInput;

public class ResponsavelActions {
    private UserInput userInput;
	private AlunoDAO alunoDAO;
    private ResponsavelDAO responsavelDAO;

    public ResponsavelActions() {
		
		try {
			userInput = new UserInput();
			responsavelDAO = new ResponsavelDAO();
            alunoDAO = new AlunoDAO();
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema no acesso a base de dados!");
		}
		
	}
	
	public void inserir() {
		
		try {
			System.out.println();

            int id = userInput.readInt("Informe o id do aluno que deseja adicionar o responsavel:");
			
			Aluno aluno = alunoDAO.findById(id);
			
			System.out.println();
			
			if(aluno == null) {
				System.out.println("Aluno inexistente!");
			}else {
				System.out.println("Informe os dados de um novo contato:");
				
				Responsavel responsavel = new Responsavel();
				responsavel.getAlunos().add(aluno);
                responsavel.setNome(userInput.readText("Nome:"));
                responsavel.setEndereco(userInput.readText("Endereço:"));
				
				responsavelDAO.insert(responsavel);
				
				System.out.println();
				System.out.println("responsavel registrado com sucesso!");
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro! Entre em responsavel com o administrador!");
			// e.printStackTrace();
		}
		
	}

	public void remover() {
		
		try {
			System.out.println();
		}catch(Exception e) {
			System.out.println("Ocorreu um erro! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void visualizarPorAluno() {
		
		try {
			System.out.println();
			
			
		}catch(Exception e) {
			System.out.println("Ocorreu um erro! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}
}
