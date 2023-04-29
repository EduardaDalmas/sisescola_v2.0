package br.com.ienh.sisescola.ui.menus;

import br.com.ienh.sisescola.ui.actions.ProfessorActions;
import br.com.ienh.sisescola.uteis.UserInput;

public class MenuProfessor implements Menu {

	public void executar() {
		
		UserInput userInput = new UserInput();
		ProfessorActions professorActions = new ProfessorActions();
		
		while (true) {
			
			System.out.println();
			System.out.println("PROFESSORES");
			System.out.println("1. Inserir");
			System.out.println("2. Atualizar");
			System.out.println("3. Remover");
			System.out.println("4. Buscar por id");
			System.out.println("5. Buscar todos");
			System.out.println("---------------------");
			System.out.println("0. Sair deste menu");
			System.out.println();
					
			int option = userInput.readInt("Informe sua opção:");
			
			if(option == 1) professorActions.inserir();
			else if(option == 2) professorActions.atualizar();
			else if(option == 3) professorActions.remover();
			else if(option == 4) professorActions.buscarPorId();
			else if(option == 5) professorActions.buscarTodos();
			else if(option == 0) break;
			
		}
		
	}
	
}
