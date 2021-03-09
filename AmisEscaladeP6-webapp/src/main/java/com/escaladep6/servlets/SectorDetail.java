package com.escaladep6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.service.SectorService;
import com.escaladep6.service.SpotService;

/**
 * Servlet implementation class SectorDetail
 */
@WebServlet("/SectorDetail")
public class SectorDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SpotService spotService = SpotService.getInstance();
	private SectorService sectorService = SectorService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String idspot = request.getParameter("idspot");		
		Integer idSpot = Integer.decode(idspot);		
		request.setAttribute("infospot", spotService.getSpot(idSpot));
		
		String idsector = request.getParameter("idsector");		
		Long idSector = Long.decode(idsector);		
		request.setAttribute("infosector", sectorService.getSector(idSector));
		request.setAttribute("idsector", Long.decode(idsector));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/detailsector.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
