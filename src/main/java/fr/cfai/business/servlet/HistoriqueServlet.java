package fr.cfai.business.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fr.cfai.scrumboard.service.HistoriqueService;
import fr.cfai.scrumboard.service.impl.HistoriqueServiceImpl;

/**
 * Servlet implementation class HistoriqueServlet
 */
@WebServlet("/HistoriqueServlet")
public class HistoriqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HistoriqueService hs;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HistoriqueServlet() {
		super();
		hs = new HistoriqueServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long idTacheConcernee = Long.parseLong(request.getParameter("idTache"));
		Gson gson = new Gson();
		String jsonHistorique = gson.toJson(hs.recupererHistoriquesParTache(idTacheConcernee));

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonHistorique);
	}

}
