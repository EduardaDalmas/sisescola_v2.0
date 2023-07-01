package br.com.ienh.sisescola.ui.menus;

import br.com.ienh.sisescola.ui.actions.DisciplinaActions;
import br.com.ienh.sisescola.uteis.UserInput;

public class MenuDisciplina {

    public void executar() {
    
        UserInput userInput = new UserInput();
		DisciplinaActions disciplinaActions = new DisciplinaActions();
		
		while (true) {
			
			System.out.println();
			System.out.println("DISCIPLINAS:");
			System.out.println("1. Inserir");
			System.out.println("2. Atualizar");
			System.out.println("3. Remover");
			System.out.println("4. Visualizar disciplinas");
			System.out.println("5. Buscar disciplina por ID");
			System.out.println("6. Vincular turma á disciplina");
			System.out.println("7. Desvincular turma á disciplina");
			System.out.println("8. Visualizar turma da disciplina");
			System.out.println("---------------------");
			System.out.println("0. Sair deste menu");
			System.out.println();
					
			int option = userInput.readInt("Informe sua opção:");
			
			if(option == 1) disciplinaActions.inserir();
			else if(option == 2) disciplinaActions.atualizar();
			else if(option == 3) disciplinaActions.remover();
			else if(option == 4) disciplinaActions.buscarTodos();
			else if(option == 5) disciplinaActions.buscarPorId();
			else if(option == 6) disciplinaActions.vincularTurma();
			else if(option == 7) disciplinaActions.desvincularTurma();
			else if(option == 8) disciplinaActions.visualizarTurmaDisciplina();
			else if(option == 0) break;
			
		}
		
    }
}
