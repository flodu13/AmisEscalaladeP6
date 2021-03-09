package com.escaladep6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.service.SpotService;

@WebServlet("/Spots")
public class Spots extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private SpotService spotService = SpotService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setAttribute("spots", spotService.findAll());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/spot.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
