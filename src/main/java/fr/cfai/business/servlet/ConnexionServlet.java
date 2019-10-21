package fr.cfai.business.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cfai.scrumboard.business.Utilisateur;
import fr.cfai.scrumboard.service.UtilisateurService;
import fr.cfai.scrumboard.service.impl.UtilisateurServiceImpl;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurService us;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        us = new UtilisateurServiceImpl(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("connexion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("EMAIL");
		String mdp = request.getParameter("MDP");
		Utilisateur utilisateur = us.recupererUtilisateur(mail,mdp);
		if (utilisateur == null) {
			request.getRequestDispatcher("connexion.jsp").forward(request, response);
		} else {
			// On crée la session HTTP
			HttpSession session =  request.getSession();
			// On met dans la session HTTP l'ID de l'utilisateur
			session.setAttribute("utilisateur", utilisateur);
			response.sendRedirect("IndexServlet");
			//request.getRequestDispatcher("IndexServlet").forward(request, response);
		}
	}

}
