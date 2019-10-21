package fr.cfai.business.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cfai.scrumboard.service.ColonneService;
import fr.cfai.scrumboard.service.TacheService;
import fr.cfai.scrumboard.service.TypeTacheService;
import fr.cfai.scrumboard.service.UtilisateurService;
import fr.cfai.scrumboard.service.impl.ColonneServiceImpl;
import fr.cfai.scrumboard.service.impl.TacheServiceImpl;
import fr.cfai.scrumboard.service.impl.TypeTacheServiceImpl;
import fr.cfai.scrumboard.service.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class IndexServlet
 */

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurService us;
	private static TypeTacheService tts;
	private static TacheService ts;
	private static ColonneService cs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexServlet() {
		super();
		us = new UtilisateurServiceImpl();
		tts = new TypeTacheServiceImpl();
		ts = new TacheServiceImpl();
		cs = new ColonneServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		if(request.getSession().getAttribute("utilisateur") == null) {
			response.sendRedirect("ConnexionServlet");
		} else {
			request.getSession().setAttribute("utilisateurs", us.recupererUtilisateurs());
			request.getSession().setAttribute("typesTaches", tts.recupererTypeTaches());
			request.getSession().setAttribute("taches", ts.recupererTaches());
			request.getSession().setAttribute("colonnes", cs.recupererColonnes());
	
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
