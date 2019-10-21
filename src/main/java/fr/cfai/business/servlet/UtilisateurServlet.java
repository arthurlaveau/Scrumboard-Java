package fr.cfai.business.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cfai.scrumboard.service.UtilisateurService;
import fr.cfai.scrumboard.service.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/UtilisateurServlet")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurService us;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurServlet() {
        super();
		us = new UtilisateurServiceImpl();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("NOM");
		String prenom = request.getParameter("PRENOM");
		String pseudo = request.getParameter("PSEUDO");
		String email = request.getParameter("EMAIL");
		String mdp = request.getParameter("MDP");
		us.ajouterUtilisateur(nom, prenom, email, pseudo, mdp, false);
	}

}
