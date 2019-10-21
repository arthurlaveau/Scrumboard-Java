package fr.cfai.scrumboard.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.Colonne;
import fr.cfai.scrumboard.business.Historique;
import fr.cfai.scrumboard.business.Tache;
import fr.cfai.scrumboard.dao.HistoriqueDao;
import fr.cfai.scrumboard.dao.impl.HistoriqueDaoImpl;
import fr.cfai.scrumboard.service.HistoriqueService;

public class HistoriqueServiceImpl implements HistoriqueService {

	private HistoriqueDao historiqueDao = new HistoriqueDaoImpl();

	@Override
	public Historique ajouterHistorique(Tache tache, Colonne colonne) {
		Historique historique = new Historique(tache, colonne);
		try {
			historique = historiqueDao.create(historique);
			return historique;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Historique recupererHistoriqueParId(Long idHistorique) {
		Historique historique = null;
		try {
			historique = historiqueDao.findOne(idHistorique);
			return historique;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Historique> recupererHistoriques() {
		try {
			return historiqueDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Historique> recupererHistoriquesParTache(Long idTache) {
		try {
			return historiqueDao.findAllByTache(idTache);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
