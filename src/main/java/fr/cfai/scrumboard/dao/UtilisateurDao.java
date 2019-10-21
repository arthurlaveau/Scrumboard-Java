package fr.cfai.scrumboard.dao;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.Utilisateur;

public interface UtilisateurDao {
	public Utilisateur create(Utilisateur utilisateur) throws SQLException;
	public Utilisateur update(Utilisateur utilisateur) throws SQLException;
	public List<Utilisateur> findAll() throws SQLException;
	public Utilisateur findOne(Long idUtilisateur) throws SQLException;
	public Utilisateur findByMailAndPassword(String email, String mdp) throws SQLException;
	public boolean delete(Long idUtilisateur) throws SQLException ;
}
