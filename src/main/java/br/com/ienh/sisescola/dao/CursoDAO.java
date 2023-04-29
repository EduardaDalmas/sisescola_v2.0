package br.com.ienh.sisescola.dao;

import br.com.ienh.sisescola.entidades.Curso;

//aplicação do padrão DAO
public class CursoDAO extends DAOGenerics<Curso, Integer> {

	public CursoDAO() throws Exception {
		super(Curso.class);
	}

}


