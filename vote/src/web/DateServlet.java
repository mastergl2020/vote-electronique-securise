package web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatDao;
import dao.DateDao;
import metier.Candidat;
import metier.DateVote;
@WebServlet("/DateServlet")
public class DateServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	DateDao um;
	public DateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
    public void init(ServletConfig config) throws ServletException {
		
		 um = new DateDao();
		
		
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("op").equals("Ajouter")) {
			//debut = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("debut"));
			//Date fin=(Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("fin")); 
			DateVote u=new DateVote(request.getParameter("debut"),request.getParameter("fin"));
			System.out.println("ok ajout bien");
			um.AddDateV(u);
			response.sendRedirect("date.jsp"); 		
		}
		if(request.getParameter("op").equals("Supprimer")) {
			int id =Integer.parseInt((String)request.getParameter("id_d"));
			um.deleteDate(id);
			response.sendRedirect("date.jsp");	
		}
	}
		
	

}
