package com.escaladep6.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.escaladep6.entities.ReservationInquiry;
import com.escaladep6.entities.Topo;
import com.escaladep6.entities.User;
import com.escaladep6.service.ReservationInquiryService;
import com.escaladep6.service.TopoService;

@WebServlet("/TopoManagement")
public class TopoManagement extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private TopoService topoService = TopoService.getInstance();
	private ReservationInquiryService reservationInquiryService = ReservationInquiryService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("currentUser");
		request.setAttribute("topos", topoService.getTopoByUser(user.getIdUser()));

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/topomanagement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Topo newTopo = new Topo();
		ReservationInquiry newReservation = new ReservationInquiry();

		Topo topo = topoService.getTopoById(Integer.valueOf(request.getParameter("idTopo")));
		
		String availableString = null;
		String reservedString = null;
		Boolean available = topo.getAvailable();
		Integer idTopo = topo.getIdTopo();
		

		if (available == false) {

			availableString = request.getParameter("available");

			if (availableString != null && availableString.equals("true")) {
				available = true;
			}

			newTopo.setAvailable(available);

			topoService.updateTopoAvailability(newTopo, idTopo);

		}

		if (available == true) {
			

			reservedString = request.getParameter("reserved");
			System.out.println(reservedString);


			if (reservedString != null && reservedString.equals("true")) {

				ReservationInquiry reservation = reservationInquiryService
						.getReservationInquiryById(Long.valueOf(request.getParameter("idReservation")));

				newReservation.setStatut("acceptée");

				reservationInquiryService.updateReservationInquiryStatut(newReservation, reservation.getIdInquiry());
				
				available =false;
				newTopo.setAvailable(available);

				topoService.updateTopoAvailability(newTopo, idTopo);

			}
		}

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/topomanagement.jsp").forward(request, response);

	}

}
