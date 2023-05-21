package br.com.ienh.sisescola.ui.actions;

import java.util.List;

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
				System.out.println("Informe os dados de um novo responsavel:");
				
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

	public void atualizar() {
		
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id do responsavel que deseja atualizar:");
			
			Responsavel responsavel = responsavelDAO.findById(id);
			
			if(responsavel == null) {
				System.out.println("Responsavel não encontrado!");
			}else {
				System.out.println("Informe os novos dados do responsavel:");
				
				responsavel.setNome(userInput.readText("Nome:"));
				responsavel.setEndereco(userInput.readText("Endereço:"));
				
				responsavelDAO.update(responsavel);
				
				System.out.println();
				System.out.println("Responsavel atualizado com sucesso!");
			}
					
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar remover o aluno! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void remover() {
		
		try {
			System.out.println();

			int id = userInput.readInt("Informe o id do aluno que deseja remover responsável:");
			
			Aluno aluno = alunoDAO.findById(id);

			if(aluno == null) {
				System.out.println("Aluno não encontrado.");
			}else {
				List<Responsavel> responsaveis = aluno.getResponsaveis();
				
				if(responsaveis.size() == 0) {
					System.out.println("Este aluno não possui responsáveis para mostrar. ");
				}else {
					System.out.println("Exibindo responsaveis do aluno:");
					
					for (Responsavel responsavel : responsaveis) {
						System.out.println(responsavel.getId() + " - " +
											responsavel.getNome() + " - " +
											responsavel.getEndereco());
					}
					
					int idResponsavel = userInput.readInt("Informe o id do responsavel que deseja remover:");
					
					Responsavel responsavel = responsavelDAO.findById(idResponsavel);
					responsavelDAO.remove(responsavel);
					
					System.out.println();
					System.out.println("Responsavel removido com sucesso!");
				}
				
			}
			
		}catch(Exception e) {
			System.out.println("Ocorreu um erro! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void visualizarPorAluno() {
		
		try {

			System.out.println();
			
			int id = userInput.readInt("Informe o id do aluno que deseja ver responsaveis:");
			
			Aluno aluno = alunoDAO.findById(id);
			
			System.out.println();
			
			if(aluno == null) {
				System.out.println("Aluno não encontrado!");
			}else {
				List<Responsavel> responsaveis = aluno.getResponsaveis();
		
				if(responsaveis.size() == 0) {
					System.out.println("Não há responsáveis para apresentar!");
				}else {
					for (Responsavel responsavel : responsaveis) {
						System.out.println(responsavel.getId() + " - " + responsavel.getNome() + " - " + responsavel.getEndereco());
					}
				}
			}
			
			
		}catch(Exception e) {
			System.out.println("Ocorreu um erro! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}
}
