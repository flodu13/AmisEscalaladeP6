package com.escaladep6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.entities.Spot;
import com.escaladep6.service.SpotService;

/**
 * Servlet implementation class SpotTag
 */
@WebServlet("/SpotTag")
public class SpotTag extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SpotService spotService = SpotService.getInstance();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		Integer idSpot = Integer.decode(id);
		
		System.out.println(Integer.decode(id));

		Spot spot = spotService.getSpot(idSpot);	

			Spot newSpot = new Spot();

			Boolean official = spot.getTag();

			if (official == false) {

				newSpot.setTag(true);

				spotService.updateSpotTag(newSpot, idSpot);
			
		}
		response.sendRedirect(request.getContextPath() + "/SpotDetail?id=" + id);
	}

}
