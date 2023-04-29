package br.com.ienh.sisescola.dao;

import br.com.ienh.sisescola.entidades.Responsavel;

//aplicação do padrão DAO
public class ResponsavelDAO extends DAOGenerics<Responsavel, Integer> {

	public ResponsavelDAO() throws Exception {
		super(Responsavel.class);
	}

}


