package web;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import com.mysql.jdbc.Blob;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import dao.VotantDao;
import metier.DE;
import metier.Votant;
import util.DBInteraction;

/**
 * Servlet implementation class Modele
 */
@WebServlet("/ModeleV")
@MultipartConfig(fileSizeThreshold = 1024*1024*2,
maxFileSize = 1024*1024*10,maxRequestSize = 1024*1024*50)
public class ModeleV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	VotantDao um;

	
    public ModeleV() {
        
    }	
	public void init(ServletConfig config) throws ServletException {
		
		um=new VotantDao();
		
		
	}	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		          RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                  rd.forward(req, resp);
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("op").equals("Ajouter"))
		{

			
				/*Part part=request.getPart("image");
				InputStream im=part.getInputStream();
				byte[] b1 = new byte[im.available()];*/
				
			   // im.read(targetArray);
				//Part image = request.getPart("image");

			    //InputStream is =image.getInputStream();

			    //byte[] targetArray= new byte[is.available()];
	            //is.read(targetArray);

			    //FileOutputStream fos = new FileOutputStream("C:\\Users\\MERIEM  SERMANI\\Desktop\\service vote_electronique_secrusé\\vote\\WebContent\\img");
			    //fos.write(targetArray);
			    //is.close();
			    //fos.close();
		
		   byte[] b = null;
	
		Votant u=new Votant(request.getParameter("nom"), request.getParameter("prenom"),request.getParameter("login"),
				   request.getParameter("pass"),request.getParameter("statue"),b);
			System.out.println("before add Votant");
			
			um.AddVotant1(u);
			System.out.println(u.getNom()+'-'+u.getPrenom()+'-'+u.getLogin()+'-'+u.getPass());
				response.sendRedirect("index.jsp");
				
			
			
		}
			
		
		/********************************************************Authentification************************************************/
		if(request.getParameter("op").equals("SE CONNECTER"))
		{ 
			try {
				String log=request.getParameter("login");
				String pwd=request.getParameter("pass");
				System.out.println(log+"------------"+pwd);
				String url="jdbc:mysql://localhost/vote";
				String driver = "com.mysql.jdbc.Driver";
				Class.forName(driver).newInstance();
				PreparedStatement stmt;
				Connection con;
				ResultSet rs;
				con=(Connection) DriverManager.getConnection(url,"root","");
				stmt=(PreparedStatement) con.prepareStatement("SELECT * from votant where login='"+log+"' and pass='"+pwd+"'");
				rs = stmt.executeQuery();
				if(rs.next()){
                         if(rs.getString("Statue").equals("PGD")) {
                        	 response.sendRedirect("pageCandidat.jsp");
						}
                         else {
                        	 response.sendRedirect("pageVotant.jsp");
                         }
					
					
					 System.out.println("authentifier");
					
	            }
				else
				{
				
					response.sendRedirect("404.html");
				}
				rs.close(); 
				stmt.close();
				con.close();
				
			}catch (SQLException e) {
				
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	    }		
		/*******************************************************update votant****************************/
        if(request.getParameter("op").equals("Modifier Votant")) {     	
         	Votant u=new Votant(request.getParameter("nom"), request.getParameter("prenom"),
    				request.getParameter("login"),request.getParameter("pass"),request.getParameter("statue"),null);
        	int id =Integer.parseInt((String)request.getParameter("id"));
        	System.out.println(u.getNom()+'-'+u.getPrenom()+'-'+u.getLogin()+'-'+u.getPass()+'-'+u.getStatue()+'-'+u.getImage());
        	um.updateVotant(id, u);
    		response.sendRedirect("ListVotant.jsp");
			
	     }
		
		
		
		
	}//dopost	
	
		
			
	

					
				
			
			
		
		
	

}
