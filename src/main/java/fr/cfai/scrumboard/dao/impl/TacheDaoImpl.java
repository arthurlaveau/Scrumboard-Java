package fr.cfai.scrumboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cfai.scrumboard.business.Tache;
import fr.cfai.scrumboard.dao.ColonneDao;
import fr.cfai.scrumboard.dao.ConnexionBdd;
import fr.cfai.scrumboard.dao.TacheDao;
import fr.cfai.scrumboard.dao.TypeTacheDao;
import fr.cfai.scrumboard.dao.UtilisateurDao;

public class TacheDaoImpl implements TacheDao {

	private Connection connection;
	private UtilisateurDao utilisateurDao;
	private ColonneDao colonneDao;
	private TypeTacheDao typeTacheDao;
	
	public TacheDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
			utilisateurDao = new UtilisateurDaoImpl();
			colonneDao = new ColonneDaoImpl();
			typeTacheDao = new TypeTacheDaoImpl();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public Tache create(Tache tache) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.AJOUT_TACHE,
				Statement.RETURN_GENERATED_KEYS);
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(tache.getDateCreation().getTime());
		ps.setString(1, tache.getLibelleTache());
		ps.setTimestamp(2, sqlDate);
		ps.setLong(3, tache.getUtilisateur().getIdUtilisateur());
		ps.setLong(4, tache.getTypeTache().getIdTypeTache());
		ps.setLong(5, tache.getColonne().getIdColonne());
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		tache.setIdTache(rs.getLong(1));
		return tache;
	}
	
	public Tache update(Tache tache, Long idColonne) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.UPDATE_TACHE,
				Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, idColonne);
		ps.setLong(2, tache.getIdTache());
		
		ps.executeUpdate();
		return tache;
	}

	@Override
	public List<Tache> findAll() throws SQLException {
		List<Tache> taches = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(fr.cfai.scrumboard.dao.Requetes.TOUTES_LES_TACHES);
		while (rs.next()) {
			Tache tache = new Tache();
			tache.setIdTache(rs.getLong(1));
			tache.setLibelleTache(rs.getString(2));
			tache.setDateCreation(rs.getTimestamp(3));
			tache.setUtilisateur(utilisateurDao.findOne(rs.getLong(4)));
			tache.setTypeTache(typeTacheDao.findOne(rs.getLong(5)));
			tache.setColonne(colonneDao.findOne(rs.getLong(6)));
			taches.add(tache);
		}
		return taches;
	}

	@Override
	public Tache findOne(Long idTache) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.TACHE_PAR_ID);
		ps.setLong(1, idTache);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Tache tache = new Tache();
			tache.setIdTache(rs.getLong(1));
			tache.setLibelleTache(rs.getString(2));
			tache.setDateCreation(rs.getTimestamp(3));
			tache.setUtilisateur(utilisateurDao.findOne(rs.getLong(4)));
			tache.setTypeTache(typeTacheDao.findOne(rs.getLong(5)));
			tache.setColonne(colonneDao.findOne(rs.getLong(6)));
			return tache;
		}
		return null;
	}

	@Override
	public boolean delete(Long idTache) throws SQLException {
		if (findOne(idTache)!=null)
		{
			java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.SUPPRESSION_TACHE);
			ps.setLong(1, idTache);
			ps.executeUpdate();
		}
		return false;
	}

}
