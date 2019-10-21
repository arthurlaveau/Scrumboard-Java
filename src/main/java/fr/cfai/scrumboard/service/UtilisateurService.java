package fr.cfai.scrumboard.service;

import java.util.List;

import fr.cfai.scrumboard.business.Utilisateur;

public interface UtilisateurService {
	
	//c
	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String motDePasse, boolean administrateur);
	
	//r
	public Utilisateur recupererUtilisateurParId(Long idUtilisateur);
	public Utilisateur recupererUtilisateur(String email, String mdp);

	public List<Utilisateur> recupererUtilisateurs();
	
	//u	
	public void modifierUtilisateur(Utilisateur utilisateur);
	
	//d
	public boolean supprimerUtilisateur(Long idUtilisateur);

}
