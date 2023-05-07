package br.com.ienh.sisescola.ui.menus;

import br.com.ienh.sisescola.uteis.UserInput;

public class MenuMain implements Menu {

	public void executar() {
		
		UserInput userInput = new UserInput();
		
		while (true) {
			
			System.out.println();
			System.out.println("MENU PRINCIPAL:");
			System.out.println("1. Alunos");
			System.out.println("2. Professores");
			System.out.println("3. Turmas");
			System.out.println("4. Disciplinas");
			System.out.println("5. Cursos");
			System.out.println("---------------------");
			System.out.println("0. Sair do programa");
			System.out.println();
					
			int option = userInput.readInt("Informe sua opção:");
			
			if(option == 1) new MenuAluno().executar();
			if(option == 2) new MenuProfessor().executar();
			if(option == 3) new MenuTurma().executar();
			if(option == 4) new MenuDisciplina().executar();
			if(option == 5) new MenuCurso().executar();
			else if(option == 0) break;
			
		}
		
		System.out.println();
		System.out.println("Saindo ...");
		System.out.println("Tchau!");
		System.out.println();
		
	}
	
}
