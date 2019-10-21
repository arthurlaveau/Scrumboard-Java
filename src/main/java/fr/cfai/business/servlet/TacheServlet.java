package fr.cfai.business.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.cfai.scrumboard.service.TacheService;
import fr.cfai.scrumboard.service.impl.TacheServiceImpl;

/**
 * Servlet implementation class TacheServlet
 */
@WebServlet("/TacheServlet")
public class TacheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TacheService ts;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TacheServlet() {
        super();
		ts = new TacheServiceImpl();
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String libelle = request.getParameter("LIBELLETACHE");
		Long idUtilisateur = Long.parseLong(request.getParameter("UTILISATEUR"));
		Long idTypeTache = Long.parseLong(request.getParameter("TYPETACHE"));
		ts.ajouterTache(libelle, idUtilisateur, idTypeTache, 16L);

	}

}
