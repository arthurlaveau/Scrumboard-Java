package fr.cfai.scrumboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cfai.scrumboard.business.Colonne;
import fr.cfai.scrumboard.dao.ColonneDao;
import fr.cfai.scrumboard.dao.ConnexionBdd;

public class ColonneDaoImpl implements ColonneDao {

	private Connection connection;
	
	public ColonneDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public Colonne create(Colonne colonne) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.AJOUT_COLONNE,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, colonne.getLibelleColonne());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		colonne.setIdColonne(rs.getLong(1));
		return colonne;
	}

	@Override
	public List<Colonne> findAll() throws SQLException {
		List<Colonne> colonnes = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(fr.cfai.scrumboard.dao.Requetes.TOUTES_LES_COLONNES);
		while (rs.next()) {
			Colonne colonne = new Colonne();
			colonne.setIdColonne(rs.getLong(1));
			colonne.setLibelleColonne(rs.getString(2));
			colonnes.add(colonne);
		}
		return colonnes;
	}

	@Override
	public Colonne findOne(Long idColonne) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.COLONNE_PAR_ID);
		ps.setLong(1, idColonne);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Colonne colonne = new Colonne();
			colonne.setIdColonne(rs.getLong(1));
			colonne.setLibelleColonne(rs.getString(2));
			return colonne;
		}
		return null;
	}

	@Override
	public boolean delete(Long idColonne) throws SQLException {
		if (findOne(idColonne)!=null)
		{
			java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.SUPPRESSION_COLONNE);
			ps.setLong(1, idColonne);
			ps.executeUpdate();
		}
		return false;
	}

}
