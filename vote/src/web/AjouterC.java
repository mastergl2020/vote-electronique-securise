package web;

import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StatementImpl;

import dao.COdao;
import dao.CandidatDao;
import metier.CO;
import metier.Candidat;
import metier.DE;
import metier.Votant;


/**
 * Servlet implementation class Modele
 */
@WebServlet("/AjouterC")
public class AjouterC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CandidatDao um;
	COdao co;

	


	
  
    public AjouterC() {
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		um=new CandidatDao();
		co=new COdao();
		
		
		
	}

	
	public void destroy() {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("op").equals("Ajouter"))
		{
			try {
				System.out.println("offff");
			    byte[] b = null;	
			    int nb=0;
				Candidat u=new Candidat(request.getParameter("nom_c"), request.getParameter("prenom_c"),
							request.getParameter("partie_c"),nb,b);
				System.out.println("before add Votant");
				um.AddCandidat1(u);
				System.out.println(u.getNom_c()+'-'+u.getPrenom_c()+'-'+u.getPartie_c());
				
				/*************************************************ajouter candidat dans Co***********************************************/
				CO c=new CO(request.getParameter("nom_c"),nb);
				co.AddCO(c);
				response.sendRedirect("listCandidat.jsp");		
				
			} catch (Exception e) {
				e.printStackTrace();
			}
					
		}
		/*************************************************************Modfier Candidat********************************************/

      if(request.getParameter("op").equals("Modifier")) {
    	   int nb=0;
    	   byte[] image=null;
    	   int id =Integer.parseInt((String)request.getParameter("id_candidats"));
           Candidat u=new Candidat(request.getParameter("nom_c"), request.getParameter("prenom_c"),
    				request.getParameter("partie_c"),nb,null);
        	
        	System.out.println(u.getNom_c());
        	um.updateCandidat(id, u); 	
        	System.out.println("update");
    		response.sendRedirect("listeCandidat.jsp");	
    		
    		
    		
			
			
			
			
		}
		
		
		
		
		
		
		
		
			
	

					
				
			
			
		
		
	}//dopost

}
