package fr.cfai.scrumboard.business;

import java.util.Date;

public class Historique {

	private Long idHistorique;
	private Date dateCreation;
	private Tache tache;
	private Colonne colonne;
	
	public Historique() {
		dateCreation = new Date();
	}
	public Historique(Tache tache, Colonne colonne) {
		this();
		this.tache = tache;
		this.colonne = colonne;
	}
	
	public Long getIdHistorique() {
		return idHistorique;
	}
	public void setIdHistorique(Long idHistorique) {
		this.idHistorique = idHistorique;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Tache getTache() {
		return tache;
	}
	public void setTache(Tache tache) {
		this.tache = tache;
	}
	public Colonne getColonne() {
		return colonne;
	}
	public void setColonne(Colonne colonne) {
		this.colonne = colonne;
	}
	
	
}
