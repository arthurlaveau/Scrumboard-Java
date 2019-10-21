package fr.cfai.scrumboard;
//package fr.cfai.scrum;
//
//import java.sql.SQLException;
//
//import fr.cfai.scrum.business.Tache;
//import fr.cfai.scrum.dao.TacheDao;
//import fr.cfai.scrum.dao.impl.TacheDaoImpl;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;
//
//public class TacheDaoTest extends TestCase {
//
//	private TacheDao tacheDao = null;
//	
//	public TacheDaoTest(String nom) {
//        super(nom);
//        tacheDao = new TacheDaoImpl();
//    }
//    
//    public void testerCreate() {
////    	Tache tache = null;
////		try {
////			tache = tacheDao.create(new Tache("Tache de Test"));
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////        assertNotNull(tache);
////        assertTrue(tache.getLibelleTache().equals("Tache de Test"));
//    }
//
//    public void testerFindAll() {
//    	try {
//			assertTrue(!tacheDao.findAll().isEmpty());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
//    
//    public void testerDelete() {
//    	Tache tache = null;
//		try {
//			tache = tacheDao.findAll().get(0);
//			long idTache = tache.getIdTache();
//			tacheDao.delete(idTache);
//			assertNull(tacheDao.findOne(idTache));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
//
//    
//    public static junit.framework.Test suite() {
//        TestSuite testSuite = new TestSuite();
//        
//        System.out.println("Lancement de la suite de test sur TacheDao");
//
//        testSuite.addTest(new TacheDaoTest("testerCreate"));        
//        testSuite.addTest(new TacheDaoTest("testerFindAll"));
//        testSuite.addTest(new TacheDaoTest("testerDelete"));
//        return testSuite;
//    }
//}
