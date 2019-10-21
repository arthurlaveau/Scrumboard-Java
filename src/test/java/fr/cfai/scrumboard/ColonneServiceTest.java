package fr.cfai.scrumboard;

import fr.cfai.scrumboard.business.Colonne;
import fr.cfai.scrumboard.service.ColonneService;
import fr.cfai.scrumboard.service.impl.ColonneServiceImpl;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ColonneServiceTest extends TestCase {

	private ColonneService colonneService = null;
	public static Colonne colonne = null;

	public ColonneServiceTest(String nom) {
		super(nom);
		colonneService = new ColonneServiceImpl();

	}

	public void testerCreate() {
		colonne = colonneService.ajouterColonne("Colonne test");
		assertNotNull(colonne);
		assertTrue(colonne.getLibelleColonne().equals("Colonne test"));
	}

	public void testerFindOne() {
		colonne = colonneService.recupererColonneParId(colonne.getIdColonne());
		assertNotNull(colonne);
	}

	public void testerFindAll() {
		assertTrue(!colonneService.recupererColonnes().isEmpty());
	}


	public static junit.framework.Test suite() {
		TestSuite testSuite = new TestSuite();

		System.out.println("Lancement de la suite de test sur ColonneServiceTest");

		testSuite.addTest(new ColonneServiceTest("testerCreate"));
		testSuite.addTest(new ColonneServiceTest("testerFindOne"));
		testSuite.addTest(new ColonneServiceTest("testerFindAll"));
		return testSuite;
	}
}
