package fr.cfai.scrumboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cfai.scrumboard.business.TypeTache;
import fr.cfai.scrumboard.dao.ConnexionBdd;
import fr.cfai.scrumboard.dao.TypeTacheDao;

public class TypeTacheDaoImpl implements TypeTacheDao {

	private Connection connection;

	public TypeTacheDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public TypeTache create(TypeTache typeTache) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.AJOUT_TYPETACHE,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, typeTache.getLibelle());
		ps.setString(2, typeTache.getDescription());

		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		typeTache.setIdTypeTache(rs.getLong(1));
		return typeTache;
	}
	
	public TypeTache update(TypeTache typeTache) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.UPDATE_TACHE,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, typeTache.getLibelle());
		ps.setString(2, typeTache.getDescription());
		ps.setLong(3, typeTache.getIdTypeTache());
		
		ps.executeUpdate();
		return typeTache;
	}

	@Override
	public List<TypeTache> findAll() throws SQLException {
		List<TypeTache> typesTaches = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(fr.cfai.scrumboard.dao.Requetes.TOUS_LES_TYPES_DE_TACHES);
		while (rs.next()) {
			TypeTache typeTache = new TypeTache();
			typeTache.setIdTypeTache(rs.getLong(1));
			typeTache.setLibelle(rs.getString(2));
			typeTache.setDescription(rs.getString(3));
			typesTaches.add(typeTache);
		}
		return typesTaches;
	}

	@Override
	public TypeTache findOne(Long idTypeTache) throws SQLException {		
		PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.TYPE_TACHE_PAR_ID);
		ps.setLong(1, idTypeTache);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			TypeTache typeTache = new TypeTache();
			typeTache.setIdTypeTache(rs.getLong(1));
			typeTache.setLibelle(rs.getString(2));
			typeTache.setDescription(rs.getString(3));
			return typeTache;
		}
		return null;
	}

	@Override
	public boolean delete(Long idTypeTache) throws SQLException {
		if (findOne(idTypeTache) != null) {
			java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.SUPPRESSION_TYPE_TACHE);
			ps.setLong(1, idTypeTache);
			ps.executeUpdate();
		}
		return false;
	}

}
