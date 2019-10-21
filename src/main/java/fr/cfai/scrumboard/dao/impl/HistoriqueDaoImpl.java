package fr.cfai.scrumboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cfai.scrumboard.business.Historique;
import fr.cfai.scrumboard.dao.ColonneDao;
import fr.cfai.scrumboard.dao.ConnexionBdd;
import fr.cfai.scrumboard.dao.HistoriqueDao;
import fr.cfai.scrumboard.dao.TacheDao;

public class HistoriqueDaoImpl implements HistoriqueDao {

	private Connection connection;
	private TacheDao tacheDao;
	private ColonneDao colonneDao;
	
	public HistoriqueDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
			tacheDao = new TacheDaoImpl();
			colonneDao = new ColonneDaoImpl();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public Historique create(Historique historique) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.AJOUT_HISTORIQUE,
				Statement.RETURN_GENERATED_KEYS);
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(historique.getDateCreation().getTime());
		ps.setTimestamp(1, sqlDate);
		ps.setLong(2, historique.getTache().getIdTache());
		ps.setLong(3, historique.getColonne().getIdColonne());

		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		historique.setIdHistorique(rs.getLong(1));
		return historique;
	}

	@Override
	public List<Historique> findAll() throws SQLException {
		List<Historique> historiques = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(fr.cfai.scrumboard.dao.Requetes.TOUS_LES_HISTORIQUES);
		while (rs.next()) {
			Historique historique = new Historique();
			historique.setIdHistorique(rs.getLong(1));
			historique.setDateCreation(rs.getTimestamp(2));
			historique.setTache(tacheDao.findOne(rs.getLong(3)));
			historiques.add(historique);
		}
		return historiques;
	}
	@Override
	public List<Historique> findAllByTache(Long idTache) throws SQLException {
		List<Historique> historiques = new ArrayList<>();
		PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.TOUS_LES_HISTORIQUES_PAR_TACHE);
		ps.setLong(1, idTache);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Historique historique = new Historique();
			historique.setIdHistorique(rs.getLong(1));
			historique.setDateCreation(rs.getTimestamp(2));
			historique.setTache(tacheDao.findOne(rs.getLong(3)));
			historique.setColonne(colonneDao.findOne(rs.getLong(4)));
			historiques.add(historique);
		}
		return historiques;
	}

	@Override
	public Historique findOne(Long idHistorique) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.HISTORIQUE_PAR_ID);
		ps.setLong(1, idHistorique);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Historique historique = new Historique();
			historique.setIdHistorique(rs.getLong(1));
			historique.setDateCreation(rs.getTimestamp(2));
			historique.setTache(tacheDao.findOne(rs.getLong(3)));
			historique.setColonne(colonneDao.findOne(rs.getLong(4)));
			return historique;
		}
		return null;
	}

	@Override
	public boolean delete(Long idHistorique) throws SQLException {
		if (findOne(idHistorique)!=null)
		{
			java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.SUPPRESSION_HISTORIQUE);
			ps.setLong(1, idHistorique);
			ps.executeUpdate();
		}
		return false;
	}

}
