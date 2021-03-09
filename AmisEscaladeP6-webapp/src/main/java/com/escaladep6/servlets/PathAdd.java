package com.escaladep6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.entities.Path;
import com.escaladep6.entities.Sector;
import com.escaladep6.service.PathService;
import com.escaladep6.service.SectorService;




@WebServlet("/PathAdd")
public class PathAdd extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private PathService pathService = PathService.getInstance();	
	private SectorService sectorService = SectorService.getInstance();	


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		String id = request.getParameter("idsector").toString();		
		Long idSector = Long.decode(id);
		request.setAttribute("infosector", sectorService.getSector(idSector));	
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/pathadd.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		Path path = new Path();	

		Sector sector = sectorService.getSector(Long.valueOf(request.getParameter("idsector")));
		
		
		path.setCotation(request.getParameter("cotation"));
		path.setHeight(Float.valueOf(request.getParameter("height")));
		path.setName(request.getParameter("name"));	
		path.setNumberOfLengh(Integer.valueOf(request.getParameter("numberoflenght")));
		path.setPointNumber(Integer.valueOf(request.getParameter("numberofpoints")));
		path.setSector(sector);
        
        pathService.addPath(path);
        
        
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/spot.jsp").forward(request, response);      
       
	}

}
