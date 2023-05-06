package br.com.ienh.sisescola.ui.actions;

import java.util.List;

import br.com.ienh.sisescola.dao.AlunoDAO;
import br.com.ienh.sisescola.dao.ProfessorDAO;
import br.com.ienh.sisescola.dao.TurmaDAO;
import br.com.ienh.sisescola.entidades.Aluno;
import br.com.ienh.sisescola.entidades.Professor;
import br.com.ienh.sisescola.entidades.Turma;
import br.com.ienh.sisescola.uteis.UserInput;

public class TurmaActions {

	private UserInput userInput;
	private TurmaDAO turmaDAO;
	private AlunoDAO alunoDAO;
	private ProfessorDAO professorDAO;
	
	public TurmaActions() {
		
		try {
			userInput = new UserInput();
			turmaDAO = new TurmaDAO();
			alunoDAO = new AlunoDAO();
			professorDAO = new ProfessorDAO();
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema no acesso a base de dados!");
		}
		
	}
	
	public void inserir() {
		try {
			Turma turma = new Turma();
			
			System.out.println();
			
			System.out.println("Informe os dados de uma nova turma:");
			turma.setSemestre(userInput.readText("Semestre: (yyyy/s)"));
			int id = userInput.readInt("Informe o id do professor:");
			
			Professor professor = professorDAO.findById(id);
			turma.setProfessor(professor);
		
			turmaDAO.insert(turma);
			
			System.out.println();
			System.out.println("Turma registrada com sucesso!");
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar registrar a turma! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}

	public void atualizar() {
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id da turma que deseja atualizar:");
			
			Turma turma = turmaDAO.findById(id);
			
			if(turma == null) {
				System.out.println("turma não encontrado!");
			}else {
				System.out.println("Informe os novos dados do turma:");
				
				turma.setSemestre(userInput.readText("Semestre:"));
				
				turmaDAO.update(turma);;
				
				System.out.println();
				System.out.println("Turma atualizada com sucesso!");
			}
					
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar atualizar a turma! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}

	public void remover() {
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id da turma que deseja remover:");
			
			Turma turma = turmaDAO.findById(id);
			
			System.out.println();
			
			if(turma == null) {
				System.out.println("Turma não encontrada!");
			}else {
				turmaDAO.remove(turma);
				System.out.println("Turma removida com sucesso!");
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar remover a turma! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}

	public void buscarPorId() {
		try {
			System.out.println();
	
			int id = userInput.readInt("Informe o id da turma que deseja buscar:");
			
			Turma turma = turmaDAO.findById(id);
			
			System.out.println();
			
			if(turma == null) {
				System.out.println("turma não encontrada!");
			}else {
				System.out.println(turma.getSemestre());
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar a turma! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}
	
	public void buscarTodos() {
		
		try {		
			System.out.println();
			List<Turma> turmas = turmaDAO.findAll();
			if(turmas.size() == 0) {
				System.out.println("Não há turmas para apresentar!");
			}else {
				for (Turma turma : turmas) {
					System.out.println(turma.getId() + " - " + turma.getSemestre() + " - " + turma.getProfessor());
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
				System.out.println("Turma não encontrada!");
			}else {
				int idAluno = userInput.readInt("Id do aluno:");
				Aluno aluno = alunoDAO.findById(idAluno);
				if(aluno == null) {
					System.out.println("Aluno não encontrado!");
				}else {
					String option = userInput.readText("Vincular aluno à turma? (s/n)");
					if(option.equals("s")) {
						turma.getAlunos().add(aluno);
						turmaDAO.update(turma);
						System.out.println("Aluno vinculado á turma.");
					} else {
						System.out.println("Procedimento cancelado.");
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
