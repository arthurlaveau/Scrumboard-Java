package fr.cfai.scrumboard.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.cfai.scrumboard.business.Utilisateur;
import fr.cfai.scrumboard.dao.ConnexionBdd;
import fr.cfai.scrumboard.dao.UtilisateurDao;

public class UtilisateurDaoImpl implements UtilisateurDao {

	private Connection connection;
	
	public UtilisateurDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public Utilisateur create(Utilisateur utilisateur) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.AJOUT_UTILISATEUR,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, utilisateur.getPseudo());
		ps.setString(2, utilisateur.getNom());
		ps.setString(3, utilisateur.getPrenom());
		ps.setString(4, utilisateur.getEmail());
		ps.setString(5, utilisateur.getMotDePasse());
		ps.setBoolean(6, utilisateur.isAdministrateur());
		
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		utilisateur.setIdUtilisateur(rs.getLong(1));
		return utilisateur;
	}
	
	public Utilisateur update(Utilisateur utilisateur) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.UPDATE_UTILISATEUR,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, utilisateur.getNom());
		ps.setString(2, utilisateur.getPrenom());
		ps.setString(3, utilisateur.getEmail());
		ps.setString(4, utilisateur.getMotDePasse());
		ps.setLong(5, utilisateur.getIdUtilisateur());
		
		ps.executeUpdate();
		return utilisateur;
	}

	@Override
	public List<Utilisateur> findAll() throws SQLException {
		List<Utilisateur> utilisateurs = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(fr.cfai.scrumboard.dao.Requetes.TOUS_LES_UTILISATEURS);
		while (rs.next()) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setIdUtilisateur(rs.getLong(1));
			utilisateur.setPseudo(rs.getString(2));
			utilisateur.setNom(rs.getString(3));
			utilisateur.setPrenom(rs.getString(4));
			utilisateur.setEmail(rs.getString(5));
			utilisateur.setAdministrateur(rs.getBoolean(7));
			utilisateurs.add(utilisateur);
		}
		return utilisateurs;
	}

	@Override
	public Utilisateur findOne(Long idUtilisateur) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.UTILISATEUR_PAR_ID);
		ps.setLong(1, idUtilisateur);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setIdUtilisateur(rs.getLong(1));
			utilisateur.setPseudo(rs.getString(2));
			utilisateur.setNom(rs.getString(3));
			utilisateur.setPrenom(rs.getString(4));
			utilisateur.setEmail(rs.getString(5));
			utilisateur.setAdministrateur(rs.getBoolean(7));
			return utilisateur;
		}
		return null;
	}
	
	@Override
	public Utilisateur findByMailAndPassword(String email, String mdp) throws SQLException {
		java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.RECUPERER_UTILISATEUR,
				Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, email);
		ps.setString(2, mdp);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			Utilisateur utilisateur = new Utilisateur();
			utilisateur.setIdUtilisateur(rs.getLong(1));
			utilisateur.setPseudo(rs.getString(2));
			utilisateur.setNom(rs.getString(3));
			utilisateur.setPrenom(rs.getString(4));
			utilisateur.setEmail(rs.getString(5));
			utilisateur.setMotDePasse(rs.getString(6));
			utilisateur.setAdministrateur(rs.getBoolean(7));
			return utilisateur;
		}
		return null;
	}

	@Override
	public boolean delete(Long idUtilisateur) throws SQLException {
		if (findOne(idUtilisateur)!=null)
		{
			java.sql.PreparedStatement ps = connection.prepareStatement(fr.cfai.scrumboard.dao.Requetes.SUPPRESSION_UTILISATEUR);
			ps.setLong(1, idUtilisateur);
			ps.executeUpdate();
		}
		return false;
	}

}
