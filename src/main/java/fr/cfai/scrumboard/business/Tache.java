package fr.cfai.scrumboard.business;

import java.util.Date;

public class Tache {

	private Long idTache;
	private String libelleTache;
	private Date dateCreation;
	private Colonne colonne;
	private TypeTache typeTache;
	private Utilisateur utilisateur;
	
	public Tache() {
		dateCreation = new Date();
	}
	public Tache(String libelleTache, Colonne colonne, Utilisateur utilisateur, TypeTache typeTache) {
		this();
		this.libelleTache = libelleTache;
		this.colonne = colonne;
		this.utilisateur = utilisateur;
		this.typeTache = typeTache;	
	}
	
	public Long getIdTache() {
		return idTache;
	}
	public void setIdTache(Long idTache) {
		this.idTache = idTache;
	}
	public String getLibelleTache() {
		return libelleTache;
	}
	public void setLibelleTache(String libelleTache) {
		this.libelleTache = libelleTache;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Colonne getColonne() {
		return colonne;
	}
	public void setColonne(Colonne colonne) {
		this.colonne = colonne;
	}
	public TypeTache getTypeTache() {
		return typeTache;
	}
	public void setTypeTache(TypeTache typeTache) {
		this.typeTache = typeTache;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", libelleTache=" + libelleTache + ", dateCreation=" + dateCreation
				+ ", colonnes=" + colonne + ", typeTache=" + typeTache + ", utilisateur=" + utilisateur + "]";
	}
	
}
