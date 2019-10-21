package fr.cfai.scrumboard.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.Utilisateur;
import fr.cfai.scrumboard.dao.UtilisateurDao;
import fr.cfai.scrumboard.dao.impl.UtilisateurDaoImpl;
import fr.cfai.scrumboard.service.UtilisateurService;

public class UtilisateurServiceImpl implements UtilisateurService {
	
	private UtilisateurDao utilDao;

	public UtilisateurServiceImpl() {
		utilDao = new UtilisateurDaoImpl();
	}

	@Override
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String motDePasse,
			boolean administrateur) {
		Utilisateur utilisateur = new Utilisateur(pseudo,nom, prenom, email, motDePasse, administrateur);
		try {
			utilisateur = utilDao.create(utilisateur);
			return utilisateur;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Utilisateur recupererUtilisateurParId(Long idUtilisateur) {
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilDao.findOne(idUtilisateur);
			return utilisateur;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Utilisateur recupererUtilisateur(String email, String mdp) {
		Utilisateur utilisateur = new Utilisateur(email, mdp);
		try {
			utilisateur = utilDao.findByMailAndPassword(email, mdp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return utilisateur;
	}

	@Override
	public List<Utilisateur> recupererUtilisateurs() {
		try {
			return utilDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void modifierUtilisateur(Utilisateur utilisateur) {
		try {
			utilDao.update(utilisateur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean supprimerUtilisateur(Long idUtilisateur) {
		try {
			utilDao.delete(idUtilisateur);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
