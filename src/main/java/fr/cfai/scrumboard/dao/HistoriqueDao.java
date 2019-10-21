package fr.cfai.scrumboard.dao;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.Historique;

public interface HistoriqueDao {
	public Historique create(Historique historique) throws SQLException;
	public List<Historique> findAll() throws SQLException;
	public List<Historique> findAllByTache(Long idTache) throws SQLException;
	public Historique findOne(Long idHistorique) throws SQLException;
	public boolean delete(Long idHistorique) throws SQLException ;
}
