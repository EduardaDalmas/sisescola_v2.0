package br.com.ienh.sisescola.dao;

import br.com.ienh.sisescola.entidades.Turma;

//aplicação do padrão DAO
public class TurmaDAO extends DAOGenerics<Turma, Integer> {

	public TurmaDAO() throws Exception {
		super(Turma.class);
	}

}


