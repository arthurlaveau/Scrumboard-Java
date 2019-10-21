package fr.cfai.scrumboard.service;

import java.util.List;

import fr.cfai.scrumboard.business.Tache;

public interface TacheService {
	//c
	public Tache ajouterTache(String libelle, Long idUtilisateur, Long idTypeTache, Long idColonne);
		
	//r
	public Tache recupererTacheParId(Long idTache);
	public List<Tache> recupererTaches();
		
	//u	
	public void modifierTache(Tache tache, Long idColonne);
		
	//d
	public boolean supprimerTache(Long idTache);
}
