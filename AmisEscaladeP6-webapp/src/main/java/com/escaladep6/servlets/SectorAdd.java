package com.escaladep6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.entities.Sector;
import com.escaladep6.entities.Spot;
import com.escaladep6.service.SectorService;
import com.escaladep6.service.SpotService;

@WebServlet("/SectorAdd")
public class SectorAdd extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private SpotService spotService = SpotService.getInstance();
	private SectorService sectorService = SectorService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		String id = request.getParameter("id").toString();		
		int idSpot = Integer.decode(id);
		request.setAttribute("infospot", spotService.getSpot(idSpot));
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/sectoradd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Sector sector = new Sector();	
		Spot spot = new Spot();
		
		
		
		spot = spotService.getSpot(Integer.valueOf(request.getParameter("id")));
		

		sector.setName(request.getParameter("name"));	
		sector.setNumberOfPath(Integer.valueOf(request.getParameter("numberofpath")));
		sector.setSpot(spot);
        
		sectorService.addSector(sector);
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/spot.jsp").forward(request, response);

	}

}
