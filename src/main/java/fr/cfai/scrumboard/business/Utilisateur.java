package fr.cfai.scrumboard.business;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {

	private Long idUtilisateur;
	private String nom;
	private String prenom;
	private String email;
	private String pseudo;
	private String motDePasse;
	private boolean administrateur;
	private List<Tache> taches;
	
	public Utilisateur() {
		taches = new ArrayList<>();
	}

	public Utilisateur(String email, String motDePasse) {
		super();
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public Utilisateur(String nom, String prenom, String email, String pseudo, String motDePasse, boolean administrateur) {
		this.email = email;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.administrateur = administrateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean isAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", email="
				+ email + ", pseudo=" + pseudo + ", motDePasse=" + motDePasse + ", administrateur=" + administrateur
				+ ", taches=" + taches + "]";
	}
	

}
