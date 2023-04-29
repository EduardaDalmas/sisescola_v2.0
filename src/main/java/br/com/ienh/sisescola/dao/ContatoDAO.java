package br.com.ienh.sisescola.dao;

import java.util.List;

import br.com.ienh.sisescola.entidades.Contato;
import jakarta.persistence.Query;

//aplicação do padrão DAO
public class ContatoDAO extends DAOGenerics<Contato, Integer> {

	public ContatoDAO() throws Exception {
		super(Contato.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Contato> obterContatosEmail(){
		String consulta = "from Contato c where c.tipo = 'email' ";
		Query query = getEntityManager().createQuery(consulta);
		return query.getResultList();
	}
	
}


