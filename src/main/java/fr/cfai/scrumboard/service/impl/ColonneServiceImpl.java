package fr.cfai.scrumboard.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.Colonne;
import fr.cfai.scrumboard.dao.ColonneDao;
import fr.cfai.scrumboard.dao.impl.ColonneDaoImpl;
import fr.cfai.scrumboard.service.ColonneService;

public class ColonneServiceImpl implements ColonneService {
	
	private ColonneDao colonneDao = new ColonneDaoImpl();

	@Override
	public Colonne ajouterColonne(String libelle) {
		Colonne colonne = new Colonne(libelle);
		try {
			colonne = colonneDao.create(colonne);
			return colonne;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Colonne recupererColonneParId(Long idColonne) {
		Colonne colonne = null;
		try {
			colonne = colonneDao.findOne(idColonne);
			return colonne;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Colonne> recupererColonnes() {
		try {
			return colonneDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean supprimerColonne(Long idColonne) {
		try {
			colonneDao.delete(idColonne);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
