package br.com.ienh.sisescola.ui.menus;

import br.com.ienh.sisescola.ui.actions.ContatoActions;
import br.com.ienh.sisescola.uteis.UserInput;

public class MenuContatos implements Menu {

	public void executar() {
		
		UserInput userInput = new UserInput();
		ContatoActions contatoActions = new ContatoActions();
		
		while (true) {
			
			System.out.println();
			System.out.println("CONTATOS:");
			System.out.println("1. Inserir");
			System.out.println("2. Atualizar");
			System.out.println("3. Remover");
			System.out.println("4. Visualizar contatos de aluno");
			System.out.println("---------------------");
			System.out.println("0. Sair deste menu");
			System.out.println();
					
			int option = userInput.readInt("Informe sua opção:");
			
			if(option == 1) contatoActions.inserir();
			else if(option == 2) contatoActions.atualizar();
			else if(option == 3) contatoActions.remover();
			else if(option == 4) contatoActions.visualizarPorAluno();
			else if(option == 0) break;
			
		}
		
	}
	
}
