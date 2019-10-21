package fr.cfai.scrumboard.service;

import java.util.List;

import fr.cfai.scrumboard.business.Colonne;
import fr.cfai.scrumboard.business.Historique;
import fr.cfai.scrumboard.business.Tache;

public interface HistoriqueService {

	//c
	public Historique ajouterHistorique(Tache tache, Colonne colonne);
		
	//r
	public Historique recupererHistoriqueParId(Long idHistorique);
	public List<Historique> recupererHistoriques();
	public List<Historique> recupererHistoriquesParTache(Long idTache);

				
}
