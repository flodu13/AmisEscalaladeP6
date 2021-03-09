package com.escaladep6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.entities.Address;
import com.escaladep6.entities.Spot;
import com.escaladep6.service.SpotService;


@WebServlet("/SpotAdd")
public class SpotAdd extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private SpotService spotService = SpotService.getInstance();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/spotadd.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		Spot spot = new Spot();
		Address address = new Address();
		
		address.setStreetNumber(request.getParameter("streetname"));
		address.setStreetName(request.getParameter("streetnumber"));
		address.setPostCode(request.getParameter("postcode"));
		address.setCity(request.getParameter("city"));
		address.setCountry(request.getParameter("country"));
		address.setRegion(request.getParameter("region"));
		
		
		spot.setName(request.getParameter("name"));
		spot.setAddress(address);
		spot.setDifficultLevel(request.getParameter("cotation"));
		spot.setNumberOfPath(Integer.valueOf(request.getParameter("paths")));
		spot.setTag(false);
        
        spotService.addSpot(spot);
        
        response.sendRedirect(request.getContextPath() + "/Spots");
           
       
	}

}
