package com.escaladep6.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.entities.ReservationInquiry;
import com.escaladep6.service.ReservationInquiryService;
import com.escaladep6.service.TopoService;
import com.escaladep6.service.UserService;

@WebServlet("/Topos")

public class Topos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TopoService topoService = TopoService.getInstance();
	private ReservationInquiryService reservationInquiryService = ReservationInquiryService.getInstance();
	private UserService userService = UserService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		request.setAttribute("topos", topoService.findAll());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/topos.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String location = null;
		String name = null;
		String availableString = null;
		String idTopo = null;
		Boolean available = false;

		
		location = request.getParameter("location");		
		name = request.getParameter("name");
		availableString = request.getParameter("available");
		
		if(availableString != null && availableString.equals("true")) {
			available=true;
		}		
		
		request.setAttribute("topos", topoService.findTopos(location, name, available));		

		idTopo = request.getParameter("idTopo");
		
		if( idTopo != null) {
			ReservationInquiry reservationInquiry = new ReservationInquiry();
			
			reservationInquiry.setTopo(topoService.getTopoById(Integer.valueOf(request.getParameter("idTopo"))));
			reservationInquiry.setUser(userService.getUser(Integer.valueOf(request.getParameter("idUser"))));
			reservationInquiry.setLendDate(new Date());
			reservationInquiry.setStatut("en cours");
			
		reservationInquiryService.addReservationInquiry(reservationInquiry);		
		}
 			
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/topos.jsp").forward(request, response);    
	}

}
