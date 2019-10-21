package fr.cfai.scrumboard.service;

import java.util.List;

import fr.cfai.scrumboard.business.Colonne;

public interface ColonneService {
	
	//c
	public Colonne ajouterColonne(String libelle);
	
	//r
	public Colonne recupererColonneParId(Long idColonne);
	public List<Colonne> recupererColonnes();
	
	//d
	public boolean supprimerColonne(Long idColonne);

}
