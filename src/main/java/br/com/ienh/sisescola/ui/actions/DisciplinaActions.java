package br.com.ienh.sisescola.ui.actions;
import java.util.List;
import br.com.ienh.sisescola.dao.DisciplinaDAO;
import br.com.ienh.sisescola.dao.TurmaDAO;
import br.com.ienh.sisescola.entidades.Curso;
import br.com.ienh.sisescola.entidades.Disciplina;
import br.com.ienh.sisescola.entidades.Turma;
import br.com.ienh.sisescola.uteis.UserInput;

public class DisciplinaActions {
    
    private UserInput userInput;
    private DisciplinaDAO disciplinaDAO;
	private TurmaDAO turmaDAO;

    public DisciplinaActions() {
		
		try {
			userInput = new UserInput();
            disciplinaDAO = new DisciplinaDAO();
			turmaDAO = new TurmaDAO();
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema no acesso a base de dados!");
		}
		
	}

    public void inserir() {
		
		try {
			System.out.println();
			
			System.out.println("Informe os dados da nova disciplina:");
			
			Disciplina disciplina = new Disciplina();
			disciplina.setNome(userInput.readText("Nome:"));
			disciplina.setCodigo(userInput.readText("código (123456):"));
			
			disciplinaDAO.insert(disciplina);
			
			System.out.println("disciplina registrado com sucesso!");
        }catch(Exception e) {
			//System.out.println("Ocorreu um erro ao tentar registrar o contato! Entre em contato com o administrador!");
			e.printStackTrace();
		}
    }

    public void atualizar() {
		
		try {

			System.out.println();
			
			int id = userInput.readInt("Informe o id da disciplina que deseja atualizar:");
			
			Disciplina disciplina = disciplinaDAO.findById(id);
			
			if(disciplina == null) {
				System.out.println("disciplina não encontrada!");
			}else {
				System.out.println("Informe os novos dados da disciplina:");
				
				disciplina.setNome(userInput.readText("Nome:"));
				
				
				disciplinaDAO.update(disciplina);;
				
				System.out.println();
				System.out.println("Disciplina atualizada com sucesso!");
			}
        }catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar atualizar a disciplina! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
    }

    public void remover() {
		
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id da disciplina que deseja remover:");
			
			Disciplina disciplina = disciplinaDAO.findById(id);
			
			System.out.println();
			
			if(disciplina == null) {
				System.out.println("disciplina não encontrada!");
			}else {
				disciplinaDAO.remove(disciplina);
				System.out.println("disciplina removida com sucesso!");
			}
        }catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar remover a disciplina! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
    }

    public void buscarTodos() {
		
		try {

			System.out.println();
			
			List<Disciplina> disciplinas = disciplinaDAO.findAll();
			
			if(disciplinas.size() == 0) {
				System.out.println("Não há disciplinas para mostrar!");
			}else {
				for (Disciplina disciplina : disciplinas) {
					System.out.println(disciplina.getId() + " - " + disciplina.getNome());
				}
			}
        }catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar as disciplinas! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
    }

	public void buscarPorId() {
		try {
			System.out.println();
	
			int id = userInput.readInt("Informe o id da disciplina que deseja buscar:");
			
			Disciplina disciplina = disciplinaDAO.findById(id);
			
			System.out.println();
			
			if(disciplina == null) {
				System.out.println("Disciplina não encontrada!");
			}else {
				System.out.println(disciplina.getNome());
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar o professor! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}

	public void vincularTurma() {
		
		try {
			int idDisciplina = userInput.readInt("Id da disciplina:");
			Disciplina disciplina = disciplinaDAO.findById(idDisciplina);
			
			System.out.println();
			
			if(disciplina == null) {
				System.out.println("disciplina não encontrada!");
			}else {
				int idTurma = userInput.readInt("Id da turma:");
				Turma turma = turmaDAO.findById(idTurma);
				if(turma == null) {
					System.out.println("turma não encontrado!");
				}else {
					String option = userInput.readText("Vincular turma à disciplina? (s/n)");
					if(option.equals("s")) {
						disciplina.getTurmas().add(turma);
						disciplinaDAO.update(disciplina);
						System.out.println("turma vinculado á disciplina.");
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

	public void visualizarTurmaDisciplina() {
		
		try {
			System.out.println();
			int idDisciplina = userInput.readInt("Id da disciplina:");
			Disciplina disciplina = disciplinaDAO.findById(idDisciplina);
			
			if(disciplina == null) {
				System.out.println("Disciplina não encontrada!");
			}else {
				System.out.println();
				List<Turma> turmas = disciplina.getTurmas();
				for (Turma turma : turmas) {
					System.out.println(turma.getId() + " - " + turma.getSemestre() + " - " + turma.getProfessor().getNome());
				}
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro! Entre em contato com o administrador!");
			e.printStackTrace();
		}
		
	}
}
