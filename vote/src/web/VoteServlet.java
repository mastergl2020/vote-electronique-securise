package web;

import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.internal.bind.v2.runtime.output.C14nXmlOutput;

import dao.COdao;
import dao.CandidatDao;
import dao.DEdao;
import dao.DateDao;
import dao.VotantDao;
import metier.CO;
import metier.Candidat;
import metier.DE;
import metier.Votant;
import openpgp.CVote;
import openpgp.WorkVote;

/**
 * Servlet implementation class Modele
 */
@WebServlet("/VoteServlet")
public class VoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DEdao um;
	VotantDao vd;
	CandidatDao cd;
	COdao co;
	DateDao d;
	


	
  
    public VoteServlet() {
        
    }

	
	public void init(ServletConfig config) throws ServletException {
		
		um=new DEdao();
		vd=new VotantDao();
		cd=new CandidatDao();
		co=new COdao();
		d=new DateDao();
		
		
	}

	
	public void destroy() {
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("op").equals("Valider votre vote")) { 
			if(d.AllDate()) {
				/***********************************************WorkDE***************************************************/
				String text=request.getParameter("name_c");
				String log=request.getParameter("login_v");			
				try {	
					WorkVote wv=new WorkVote();
					SecretKey key=wv.generatekey("AES");
					Cipher chipher = Cipher.getInstance("AES");
					byte[] encryptedData =wv.encrypteString(text, key, chipher);
					String encryptedString =new String(encryptedData);
					System.out.println(encryptedString);
					
					String decrypted=wv.decryptString(encryptedData,key,chipher);
					System.out.println(decrypted);
					
					String url="jdbc:mysql://localhost/vote";
					String driver = "com.mysql.jdbc.Driver";
					Class.forName(driver).newInstance();
					PreparedStatement stmt1,stmt2,stmt3;
					Connection con;
					ResultSet rs1,rs2,rs3;
					con=(Connection) DriverManager.getConnection(url,"root","");
					stmt1=(PreparedStatement) con.prepareStatement("SELECT * from de where login_v='"+log+"'");
					rs1 = stmt1.executeQuery();
					if(rs1.next()){
						
						response.sendRedirect("ok.jsp");
						System.out.println("Nom du login: "+rs1.getString("login_v"));
						 System.out.println("Impossible d'ajout");
						
		            }
					else
					{
						DE u=new DE(encryptedString,log);
						um.AddDE(u);
						response.sendRedirect("DE.jsp");
					}
					rs1.close(); 
					stmt1.close();
					
					/*****************************************************WorkCO******************************************/
					int count=1;
					stmt2=(PreparedStatement) con.prepareStatement("SELECT * from co where nom_co='"+decrypted+"'");
					rs2 = stmt2.executeQuery();
					if(rs2.next()){
					
						count=count+rs2.getInt("nbr");
						System.out.println(rs2.getInt("nbr"));
						System.out.println(count);
						co.deleteCO(decrypted);
						CO c=new CO(decrypted,count);
					    System.out.println("delete");
					    co.AddCO(c);
					   
						
		            }
					else
					{
					
						System.out.println("not calcul");
						
					}
					rs2.close(); 
					stmt2.close();
					
					/*****************************************************Modifier Candidat******************************************/
					int count1=1;
					stmt3=(PreparedStatement) con.prepareStatement("SELECT * from candidat where nom_c='"+decrypted+"'");
					rs3 = stmt3.executeQuery();
					if(rs3.next()){
					
						count1=count1+rs3.getInt("nbr_votes");
						System.out.println(rs3.getInt("nbr_votes"));
						System.out.println(count1);
						Candidat c1=new Candidat(decrypted, rs3.getString("prenom_c"), rs3.getString("partie_c"), count1,rs3.getBytes("image_c"));
						cd.deleteCandidat(decrypted);
					    System.out.println("delete");
					    cd.AddCandidat1(c1);
					   
						
		            }
					else
					{
					
						System.out.println("not calcul");
						
					}
					rs3.close(); 
					stmt3.close();
					con.close();
					
					
						
				} catch (Exception e) {
					
				}

				
			}
			
			
			
			
			
			
			
				
		}
			
			
		
		
		
		
		
		
			
	

					
				
			
			
		
		
	}//dopost


	

}
