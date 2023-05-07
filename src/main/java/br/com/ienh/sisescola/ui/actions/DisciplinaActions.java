package br.com.ienh.sisescola.ui.actions;
import java.util.List;
import br.com.ienh.sisescola.dao.DisciplinaDAO;
import br.com.ienh.sisescola.entidades.Disciplina;
import br.com.ienh.sisescola.uteis.UserInput;

public class DisciplinaActions {
    
    private UserInput userInput;
    private DisciplinaDAO disciplinaDAO;

    public DisciplinaActions() {
		
		try {
			userInput = new UserInput();
            disciplinaDAO = new DisciplinaDAO();
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
			System.out.println("Ocorreu um erro ao tentar registrar o contato! Entre em contato com o administrador!");
			//e.printStackTrace();
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
}
