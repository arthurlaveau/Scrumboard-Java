package fr.cfai.business.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.cfai.scrumboard.business.Tache;
import fr.cfai.scrumboard.service.TacheService;
import fr.cfai.scrumboard.service.impl.TacheServiceImpl;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TacheService ts;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DetailServlet() {
		super();
		ts = new TacheServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Long idTacheConcernee = Long.parseLong(request.getParameter("idTache"));

		Tache tache = ts.recupererTacheParId(idTacheConcernee);
		
		Gson gson = new Gson();
		String jsonTache = gson.toJson(tache);
				
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(jsonTache);
		
	}

}
