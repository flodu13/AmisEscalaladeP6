package com.escaladep6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.escaladep6.entities.User;
import com.escaladep6.service.UserService;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private UserService userService = UserService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/connexion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		String login= request.getParameter("login"); 
        String password= request.getParameter("password"); 
               
        User user =userService.login(login, password);   
        
        HttpSession session = request.getSession();

        session.setAttribute("currentUser", user);
                 
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/accueil.jsp").forward(request, response);    
	}

}
