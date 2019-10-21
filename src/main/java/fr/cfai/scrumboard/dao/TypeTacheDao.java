package fr.cfai.scrumboard.dao;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.TypeTache;

public interface TypeTacheDao {
	public TypeTache create(TypeTache typeTache) throws SQLException;
	public TypeTache update(TypeTache typeTache) throws SQLException;
	public List<TypeTache> findAll() throws SQLException;
	public TypeTache findOne(Long idTypeTache) throws SQLException;
	public boolean delete(Long idTypeTache) throws SQLException ;
}
