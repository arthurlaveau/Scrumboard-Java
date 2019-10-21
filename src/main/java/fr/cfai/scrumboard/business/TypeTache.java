package fr.cfai.scrumboard.business;

import java.util.ArrayList;
import java.util.List;

public class TypeTache {

	private Long idTypeTache;
	private String libelle;
	private String description;
	private List<Tache> taches;
	
	public TypeTache() {
		taches = new ArrayList<>();
	}
	public TypeTache(String libelle, String description) {
		this();
		this.libelle = libelle;
		this.description = description;
	}
	
	public Long getIdTypeTache() {
		return idTypeTache;
	}
	public void setIdTypeTache(Long idTypeTache) {
		this.idTypeTache = idTypeTache;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	
	@Override
	public String toString() {
		return "TypeTache [idTypeTache=" + idTypeTache + ", libelle=" + libelle + ", description=" + description
				+ ", taches=" + taches + "]";
	}
	
}
