package br.com.ienh.sisescola.ui.menus;

import br.com.ienh.sisescola.ui.actions.TurmaActions;
import br.com.ienh.sisescola.uteis.UserInput;

public class MenuTurma implements Menu {

	public void executar() {
		
		UserInput userInput = new UserInput();
		TurmaActions turmaActions = new TurmaActions();
		
		while (true) {
			
			System.out.println();
			System.out.println("TURMAS");
			System.out.println("1. Inserir");
			System.out.println("2. Atualizar");
			System.out.println("3. Remover");
			System.out.println("4. Buscar por id");
			System.out.println("5. Buscar todos");
			System.out.println("6. Vincular aluno a turma");
			System.out.println("7. Desvincular aluno da turma");
			System.out.println("8. Visualizar alunos da turma");
			System.out.println("9. Vincular disciplina a turma");
			System.out.println("10. Desvincular disciplina da turma");
			System.out.println("11. Visualizar disciplina da turma");
			System.out.println("12. Vincular professor a turma");
			System.out.println("---------------------");
			System.out.println("0. Sair deste menu");
			System.out.println();
					
			int option = userInput.readInt("Informe sua opção:");
			
			if(option == 1) turmaActions.inserir();
			else if(option == 2) turmaActions.atualizar();
			else if(option == 3) turmaActions.remover();
			else if(option == 4) turmaActions.buscarPorId();
			else if(option == 5) turmaActions.buscarTodos();
			else if(option == 6) turmaActions.vincularAluno();
			else if(option == 8) turmaActions.visualizarAlunosTurma();
			else if(option == 7) turmaActions.desvincularAluno();
			else if(option == 9) turmaActions.vincularDisciplina();
			else if(option == 10) turmaActions.desvincularDisciplina();
			else if(option == 11) turmaActions.visualizarDisciplinaTurma();
			else if(option == 12) turmaActions.vincularProfessor();
			else if(option == 0) break;
			
		}
		
	}
	
}
