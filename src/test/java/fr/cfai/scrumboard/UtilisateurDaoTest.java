package fr.cfai.scrumboard;

import java.sql.SQLException;

import fr.cfai.scrumboard.business.Utilisateur;
import fr.cfai.scrumboard.dao.UtilisateurDao;
import fr.cfai.scrumboard.dao.impl.UtilisateurDaoImpl;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UtilisateurDaoTest extends TestCase {

	private UtilisateurDao utilisateurDao = null;

	public UtilisateurDaoTest(String nom) {
        super(nom);
        utilisateurDao = new UtilisateurDaoImpl();
    }

	public void testerCreate() {
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurDao.create(new Utilisateur("Azag", "Jordan", "jordan@azag.com", "AzagJo", "1234", true));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull(utilisateur);
		assertTrue(utilisateur.getNom().equals("Azag"));
		assertTrue(utilisateur.getPrenom().equals("Jordan"));
		assertTrue(utilisateur.getEmail().equals("jordan@azag.com"));
		assertTrue(utilisateur.getPseudo().equals("AzagJo"));
		assertTrue(utilisateur.getMotDePasse().equals("1234"));
		assertTrue(utilisateur.isAdministrateur());
	}

	public void testerFindAll() {
		try {
			assertTrue(!utilisateurDao.findAll().isEmpty());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testerFindOne() {
		Utilisateur utilisateur = null;
		try {	
			utilisateur = utilisateurDao.create(new Utilisateur("Azag", "Jordan", "jordan@azag.com", "AzagJo", "1234", true));
			assertNotNull(utilisateurDao.findOne(utilisateur.getIdUtilisateur()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testerDelete() {
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurDao.findAll().get(0);
			long idUtilisateur = utilisateur.getIdUtilisateur();
			utilisateurDao.delete(idUtilisateur);
			assertNull(utilisateurDao.findOne(idUtilisateur));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static junit.framework.Test suite() {
		TestSuite testSuite = new TestSuite();

		System.out.println("Lancement de la suite de test sur UtilisateurDao");

		testSuite.addTest(new UtilisateurDaoTest("testerCreate"));
		testSuite.addTest(new UtilisateurDaoTest("testerFindAll"));
		testSuite.addTest(new UtilisateurDaoTest("testerFindOne"));
		testSuite.addTest(new UtilisateurDaoTest("testerDelete"));
		return testSuite;
	}
}
