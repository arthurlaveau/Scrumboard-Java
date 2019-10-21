package fr.cfai.scrumboard.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.Tache;
import fr.cfai.scrumboard.dao.TacheDao;
import fr.cfai.scrumboard.dao.impl.TacheDaoImpl;
import fr.cfai.scrumboard.service.ColonneService;
import fr.cfai.scrumboard.service.TacheService;
import fr.cfai.scrumboard.service.TypeTacheService;
import fr.cfai.scrumboard.service.UtilisateurService;

public class TacheServiceImpl implements TacheService {

	private TacheDao tacheDao;
	private UtilisateurService us;
	private TypeTacheService tts;
	private ColonneService cs;
	
	public TacheServiceImpl() {
		tacheDao = new TacheDaoImpl();
		us = new UtilisateurServiceImpl();
		tts = new TypeTacheServiceImpl();
		cs = new ColonneServiceImpl();
    }
	
	@Override
	public Tache ajouterTache(String libelle, Long idUtilisateur, Long idTypeTache,
			Long idColonne) {
		Tache tache = new Tache();
		tache.setLibelleTache(libelle);
		tache.setUtilisateur(us.recupererUtilisateurParId(idUtilisateur));
		tache.setTypeTache(tts.recupererTypeTacheParId(idTypeTache));
		tache.setColonne(cs.recupererColonneParId(idColonne));
		try {
			tache = tacheDao.create(tache);
			return tache;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Tache recupererTacheParId(Long idTache) {
		Tache tache = null;
		try {
			tache = tacheDao.findOne(idTache);
			return tache;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Tache> recupererTaches() {
		try {
			return tacheDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void modifierTache(Tache tache, Long idColonne) {
		try {
			tacheDao.update(tache, idColonne);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean supprimerTache(Long idTache) {
		try {
			tacheDao.delete(idTache);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
