package br.com.ienh.sisescola.ui.menus;

import br.com.ienh.sisescola.ui.actions.AlunoActions;
import br.com.ienh.sisescola.uteis.UserInput;

public class MenuAluno implements Menu {

	public void executar() {
		
		UserInput userInput = new UserInput();
		AlunoActions alunoActions = new AlunoActions();
		
		while (true) {
			
			System.out.println();
			System.out.println("ALUNOS");
			System.out.println("1. Inserir");
			System.out.println("2. Atualizar");
			System.out.println("3. Remover");
			System.out.println("4. Buscar por id");
			System.out.println("5. Buscar todos");
			System.out.println("6. Contatos de aluno");
			System.out.println("---------------------");
			System.out.println("0. Sair deste menu");
			System.out.println();
					
			int option = userInput.readInt("Informe sua opção:");
			
			if(option == 1) alunoActions.inserir();
			else if(option == 2) alunoActions.atualizar();
			else if(option == 3) alunoActions.remover();
			else if(option == 4) alunoActions.buscarPorId();
			else if(option == 5) alunoActions.buscarTodos();
			else if(option == 6) new MenuContatos().executar();
			else if(option == 0) break;
			
		}
		
	}
	
}