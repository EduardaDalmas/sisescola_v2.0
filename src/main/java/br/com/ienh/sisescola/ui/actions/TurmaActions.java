package br.com.ienh.sisescola.ui.actions;

import java.util.List;

import br.com.ienh.sisescola.dao.AlunoDAO;
import br.com.ienh.sisescola.dao.TurmaDAO;
import br.com.ienh.sisescola.entidades.Aluno;
import br.com.ienh.sisescola.entidades.Turma;
import br.com.ienh.sisescola.uteis.UserInput;

public class TurmaActions {

	private UserInput userInput;
	private TurmaDAO turmaDAO;
	private AlunoDAO alunoDAO;
	
	public TurmaActions() {
		
		try {
			userInput = new UserInput();
			turmaDAO = new TurmaDAO();
			alunoDAO = new AlunoDAO();
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema no acesso a base de dados!");
		}
		
	}
	
	public void inserir() {
		
	}

	public void atualizar() {
		
	}

	public void remover() {
		
	}

	public void buscarPorId() {
		
	}
	
	public void buscarTodos() {
		
		try {		
			System.out.println();
			List<Turma> turmas = turmaDAO.findAll();
			if(turmas.size() == 0) {
				System.out.println("NÃO HÁ TURMAS PARA MOSTRAR!");
			}else {
				for (Turma turma : turmas) {
					System.out.println(turma.getId() + " - " + turma.getSemestre());
				}
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar as turmas! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void vincularAluno() {
		
		try {
			int idTurma = userInput.readInt("Id da turma:");
			Turma turma = turmaDAO.findById(idTurma);
			
			System.out.println();
			
			if(turma == null) {
				System.out.println("TURMA NÃO ENCONTRADA!");
			}else {
				int idAluno = userInput.readInt("Id do aluno:");
				Aluno aluno = alunoDAO.findById(idAluno);
				if(aluno == null) {
					System.out.println("ALUNO NÃO ENCONTRADO!");
				}else {
					String option = userInput.readText("Vincular aluno à turma? (y/n)");
					if(option.equals("y")) {
						turma.getAlunos().add(aluno);
						turmaDAO.update(turma);
						System.out.println("ALUNO VINCULADO À TURMA.");
					}
				}
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
		
	}

	public void visualizarAlunosTurma() {
		
		try {
			System.out.println();
			int idTurma = userInput.readInt("Id da turma:");
			Turma turma = turmaDAO.findById(idTurma);
			
			if(turma == null) {
				System.out.println("TURMA NÃO ENCONTRADA!");
			}else {
				System.out.println();
				List<Aluno> alunos = turma.getAlunos();
				for (Aluno aluno : alunos) {
					System.out.println(aluno.getId() + " - " + aluno.getNome());
				}
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro! Entre em contato com o administrador!");
			e.printStackTrace();
		}
		
	}
	
}
