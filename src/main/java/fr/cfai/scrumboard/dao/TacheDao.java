package fr.cfai.scrumboard.dao;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.Tache;

public interface TacheDao {
	public Tache create(Tache tache) throws SQLException;
	public Tache update(Tache tache, Long idColonne) throws SQLException;
	public List<Tache> findAll() throws SQLException;
	public Tache findOne(Long idTache) throws SQLException;
	public boolean delete(Long idTache) throws SQLException ;
}
