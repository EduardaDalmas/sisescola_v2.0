package br.com.ienh.sisescola.ui.actions;
import java.util.List;
import br.com.ienh.sisescola.dao.CursoDAO;
import br.com.ienh.sisescola.entidades.Curso;
import br.com.ienh.sisescola.uteis.UserInput;

public class CursoActions {
    private UserInput userInput;
    private CursoDAO cursoDAO;

    public CursoActions() {
		
		try {
			userInput = new UserInput();
            cursoDAO = new CursoDAO();
		} catch (Exception e) {
			System.out.println("Ocorreu algum problema no acesso a base de dados!");
		}
		
	}

    public void inserir() {
		
		try {
			System.out.println();
			
			System.out.println("Informe os dados do curso:");
			
			Curso curso = new Curso();
			curso.setNome(userInput.readText("Nome:"));
			curso.setCoordenador(userInput.readText("Coordenador:"));
			
			cursoDAO.insert(curso);
			
			System.out.println("curso registrado com sucesso!");
        }catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar registrar o curso! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
    }

    public void atualizar() {
		
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id do curso que deseja atualizar:");
			
			Curso curso = cursoDAO.findById(id);
			
			if(curso == null) {
				System.out.println("curso não encontrado!");
			}else {
				System.out.println("Informe os novos dados do curso:");
				
				curso.setNome(userInput.readText("Nome:"));
				curso.setCoordenador(userInput.readText("Coordenador:"));
				
				cursoDAO.update(curso);;
				
				System.out.println();
				System.out.println("curso atualizado com sucesso!");
			}
        }catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar atualizar o curso! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
    }

    public void remover() {
		
		try {
			System.out.println();
			
			int id = userInput.readInt("Informe o id do curso que deseja remover:");
			
			Curso curso = cursoDAO.findById(id);
			
			System.out.println();
			
			if(curso == null) {
				System.out.println("curso não encontrado!");
			}else {
				cursoDAO.remove(curso);
				System.out.println("curso removido com sucesso!");
			}
        }catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar remover o curso! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
    }

    public void buscarTodos() {
		
		try {
			System.out.println();
			
			List<Curso> cursos = cursoDAO.findAll();
			
			if(cursos.size() == 0) {
				System.out.println("Não há cursos para mostrar!");
			}else {
				for (Curso curso : cursos) {
					System.out.println(curso.getId() + " - " + curso.getNome() + " - " + curso.getCoordenador());
				}
			}
        }catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar listar os cursos! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
    }

	public void buscarPorId() {
		try {
			System.out.println();
	
			int id = userInput.readInt("Informe o id do curso que deseja buscar:");
			
			Curso curso = cursoDAO.findById(id);
			
			System.out.println();
			
			if(curso == null) {
				System.out.println("curso não encontrada!");
			}else {
				System.out.println(curso.getNome());
			}
		}catch(Exception e) {
			System.out.println("Ocorreu um erro ao tentar buscar o curso! Entre em contato com o administrador!");
			//e.printStackTrace();
		}
	}
}
