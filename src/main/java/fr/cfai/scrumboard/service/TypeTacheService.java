package fr.cfai.scrumboard.service;

import java.util.List;

import fr.cfai.scrumboard.business.TypeTache;

public interface TypeTacheService {

	//c
	public TypeTache ajouterTypeTache(String nom, String correspondance);
		
	//r
	public TypeTache recupererTypeTacheParId(Long idTypeTache);
	public List<TypeTache> recupererTypeTaches();
		
	//u	
	public void modifierTypeTache(TypeTache typeTache);
		
	//d
	public boolean supprimerTypeTache(Long idTypeTache);
}
