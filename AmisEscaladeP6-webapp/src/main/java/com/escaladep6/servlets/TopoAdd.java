package com.escaladep6.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.escaladep6.entities.Topo;
import com.escaladep6.entities.User;
import com.escaladep6.service.TopoService;

@WebServlet("/TopoAdd")
public class TopoAdd extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private TopoService topoService = TopoService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/topoadd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();	
		User user = (User) session.getAttribute("currentUser");
		
		Topo topo = new Topo();
			
		topo.setName(request.getParameter("name"));	
		topo.setAvailable(true);
		topo.setDescription(request.getParameter("description"));
		topo.setLocation(request.getParameter("location"));
		topo.setPublicationDate(new Date());
		topo.setUser(user);
        		
		topoService.addTopo(topo);
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/account.jsp").forward(request, response);

	}


}
