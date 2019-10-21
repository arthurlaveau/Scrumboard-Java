package fr.cfai.scrumboard.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.cfai.scrumboard.business.TypeTache;
import fr.cfai.scrumboard.dao.TypeTacheDao;
import fr.cfai.scrumboard.dao.impl.TypeTacheDaoImpl;
import fr.cfai.scrumboard.service.TypeTacheService;

public class TypeTacheServiceImpl implements TypeTacheService {
	
	private TypeTacheDao typeTacheDao = new TypeTacheDaoImpl();

	@Override
	public TypeTache ajouterTypeTache(String nom, String correspondance) {
		TypeTache typeTache = new TypeTache(nom, correspondance);
		try {
			typeTache = typeTacheDao.create(typeTache);
			return typeTache;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TypeTache recupererTypeTacheParId(Long idTypeTache) {
		TypeTache typeTache = null;
		try {
			typeTache = typeTacheDao.findOne(idTypeTache);
			return typeTache;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<TypeTache> recupererTypeTaches() {
		try {
			return typeTacheDao.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void modifierTypeTache(TypeTache typeTache) {
		try {
			typeTacheDao.update(typeTache);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean supprimerTypeTache(Long idTypeTache) {
		try {
			typeTacheDao.delete(idTypeTache);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
