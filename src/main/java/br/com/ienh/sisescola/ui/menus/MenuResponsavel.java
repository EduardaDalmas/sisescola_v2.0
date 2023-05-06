package br.com.ienh.sisescola.ui.menus;

import br.com.ienh.sisescola.ui.actions.ResponsavelActions;
import br.com.ienh.sisescola.uteis.UserInput;

public class MenuResponsavel implements Menu {

    public void executar() {
        UserInput userInput = new UserInput();
        ResponsavelActions responsavelActions = new ResponsavelActions();

        while (true) {
			
			System.out.println();
			System.out.println("RESPONSAVEL:");
			System.out.println("1. Inserir");
			System.out.println("2. Remover");
			System.out.println("3. Visualizar responsaveis de aluno");
			System.out.println("---------------------");
			System.out.println("0. Sair deste menu");
			System.out.println();
					
			int option = userInput.readInt("Informe sua opção:");
			
			if(option == 1) responsavelActions.inserir();
			else if(option == 2) responsavelActions.remover();
			else if(option == 3) responsavelActions.visualizarPorAluno();
			else if(option == 0) break;
			
		}
    }
    
}
