package com.escaladep6.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.escaladep6.entities.Comment;
import com.escaladep6.service.CommentService;


@WebServlet("/CommentManagement")
public class CommentManagement extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CommentService commentService = CommentService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		
		String id = request.getParameter("idcomment").toString();		
		Long idComment = Long.decode(id);
				
		request.setAttribute("comment", commentService.getComment(idComment));
	
	
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/commentmanagement.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Comment comment = commentService.getComment(Long.valueOf(request.getParameter("idComment")));
		Comment newComment = new Comment();
		
		String deleteString = request.getParameter("delete");
		
		if(deleteString != null && deleteString.equals("true")) {
			
		//	commentService.deleteComment(comment);
			
		}
		
		if(deleteString == null) {
			
			newComment.setComment(request.getParameter("comment"));
		//	commentService.updateComment(newComment, comment.getIdComment());
		}
		
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/accueil.jsp").forward(request, response);

	}
}