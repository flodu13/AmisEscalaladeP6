package com.escaladep6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.service.SpotService;

/**
 * Servlet implementation class Research
 */
@WebServlet("/Research")
public class Research extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SpotService spotService = SpotService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
				
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/research.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String region = null;
		String difficult = null;
		
		String name = null;
		
		region = request.getParameter("region");		
		difficult = request.getParameter("difficult");	
		name = request.getParameter("name");
		request.setAttribute("spotsfind", spotService.findSpots(region, difficult, name));
 			
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/research.jsp").forward(request, response);    
	}

}