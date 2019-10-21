package fr.cfai.business.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cfai.scrumboard.business.Colonne;
import fr.cfai.scrumboard.business.Tache;
import fr.cfai.scrumboard.service.ColonneService;
import fr.cfai.scrumboard.service.HistoriqueService;
import fr.cfai.scrumboard.service.TacheService;
import fr.cfai.scrumboard.service.impl.ColonneServiceImpl;
import fr.cfai.scrumboard.service.impl.HistoriqueServiceImpl;
import fr.cfai.scrumboard.service.impl.TacheServiceImpl;

/**
 * Servlet implementation class MouvementServlet
 */
@WebServlet("/MouvementServlet")
public class MouvementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TacheService ts;
	private static HistoriqueService hs;
	private static ColonneService cs;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MouvementServlet() {
        super();
        ts = new TacheServiceImpl();
		hs = new HistoriqueServiceImpl();
		cs = new ColonneServiceImpl();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tache tache = ts.recupererTacheParId(Long.parseLong(request.getParameter("idTache")));
		Colonne colonne = cs.recupererColonneParId(Long.parseLong(request.getParameter("idColonne")));
		ts.modifierTache(tache, Long.parseLong(request.getParameter("idColonne")));
		hs.ajouterHistorique(tache, colonne);
	}

}
