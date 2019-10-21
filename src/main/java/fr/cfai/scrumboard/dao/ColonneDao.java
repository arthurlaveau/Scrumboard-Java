package fr.cfai.scrumboard.dao;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.Colonne;

public interface ColonneDao {
	public Colonne create(Colonne colonne) throws SQLException;
	public List<Colonne> findAll() throws SQLException;
	public Colonne findOne(Long idColonne) throws SQLException;
	public boolean delete(Long idColonne) throws SQLException ;
}
