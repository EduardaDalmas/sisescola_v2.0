package br.com.ienh.sisescola.ui.menus;

import br.com.ienh.sisescola.ui.actions.CursoActions;
import br.com.ienh.sisescola.uteis.UserInput;

public class MenuCurso {
    
    public void executar() {
    
        UserInput userInput = new UserInput();
		CursoActions cursoActions = new CursoActions();
		
		while (true) {
			
			System.out.println();
			System.out.println("CURSOS:");
			System.out.println("1. Inserir");
			System.out.println("2. Atualizar");
			System.out.println("3. Remover");
			System.out.println("4. Visualizar cursos");
			System.out.println("5. Buscar curso por ID");
			System.out.println("6. Vincular disciplina ao curso");
			System.out.println("7. Desvincular disciplina do curso");
			System.out.println("8. Visualizar disciplina do curso");
			System.out.println("---------------------");
			System.out.println("0. Sair deste menu");
			System.out.println();
					
			int option = userInput.readInt("Informe sua opção:");
			
			if(option == 1) cursoActions.inserir();
			else if(option == 2) cursoActions.atualizar();
			else if(option == 3) cursoActions.remover();
			else if(option == 4) cursoActions.buscarTodos();
			else if(option == 5) cursoActions.buscarPorId();
			else if(option == 6) cursoActions.vincularDisciplina();
			else if(option == 7) cursoActions.desvincularDisciplina();
			else if(option == 8) cursoActions.visualizarDisciplinaCurso();
			else if(option == 0) break;
			
		}
		
    }
}
