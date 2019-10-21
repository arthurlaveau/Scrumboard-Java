package fr.cfai.scrumboard.business;

import java.util.ArrayList;
import java.util.List;

public class Colonne {

	private Long idColonne;
	private String libelleColonne;
	private List<Tache> taches;
	
	public Colonne() {
		taches = new ArrayList<>();
	}
	public Colonne(String libelleColonne) {
		this();
		this.libelleColonne = libelleColonne;
	}
	
	public Long getIdColonne() {
		return idColonne;
	}
	public void setIdColonne(Long idColonne) {
		this.idColonne = idColonne;
	}
	public String getLibelleColonne() {
		return libelleColonne;
	}
	public void setLibelleColonne(String libelleColonne) {
		this.libelleColonne = libelleColonne;
	}
	public List<Tache> getTaches() {
		return taches;
	}
	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}
	@Override
	public String toString() {
		return "Colonne [idColonne=" + idColonne + ", libelleColonne=" + libelleColonne + ", taches=" + taches + "]";
	}

}
