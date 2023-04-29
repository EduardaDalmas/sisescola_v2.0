package br.com.ienh.sisescola.dao;

import br.com.ienh.sisescola.entidades.Aluno;

//aplicação do padrão DAO
public class AlunoDAO extends DAOGenerics<Aluno, Integer> {

	public AlunoDAO() throws Exception {
		super(Aluno.class);
	}
	
}


