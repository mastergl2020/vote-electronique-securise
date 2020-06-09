package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import metier.Votant;
import util.DBInteraction;
import metier.Votant;
public class VotantDao  {
/***********************************************Ajouter un Votant********************************/
	public int AddVotant(Votant p) {

		DBInteraction.connect();
		String sql="insert into votant(nom,prenom,login,pass) values('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getLogin()+"','"+p.getPass()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
/***************************************************************************************************/
	public int AddVotant1(Votant p) {

		DBInteraction.connect();
		String sql="insert into votant(nom,prenom,login,pass,statue,image) values('"+p.getNom()+"','"+p.getPrenom()+"','"+p.getLogin()+"','"+p.getPass()+
				"','"+p.getStatue()+"','"+p.getImage()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
/*********************************************Recherche Votant*********************************/
	
	public Votant FindVotant(int id) {
		
		Votant p=null;
		DBInteraction
		.connect();
		String sql="select * from votant where id="+id;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				p=new Votant(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				p.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		return p;
	}
/************************************Supprimer Votant***************************************/
	
	public int deleteVotant(int id) {
		DBInteraction.connect();
		String sql="delete from votant where id='"+id+"'";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;	
	}

/**************************************modifier Dociment************************************/
	
	public int updateVotant(int id, Votant p) {
		DBInteraction.connect();
		String sql="update votant set nom='"+p.getNom()+"',prenom='"+p.getPrenom()+"',login='"+p.getLogin()+"',statue='"+p.getStatue()+"',image='"+p.getImage()+"' where id='"+id+"'";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
/***********************************Consulter Votant***************************************/
	
	public ArrayList<Votant> AllVotant() {
		ArrayList<Votant> ps=new ArrayList<>();
		DBInteraction.connect();
		String sql="select * from votant ";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				Votant p=new Votant(rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
				p.setId(rs.getInt(1));
				ps.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		
		return ps;
	}
/********************************************afficher votant si login********************************/
	public ArrayList<Votant> AllVotantLogin() {
		ArrayList<Votant> ps=new ArrayList<>();
		DBInteraction.connect();
		String sql="select login from votant ";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				Votant p=new Votant(rs.getString(4));
				p.setId(rs.getInt(1));
				ps.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		
		return ps;
	}
/****************************************************Auth***************************************************************/
public Votant Auth(String login, String pass) {
		Votant u=null;
		DBInteraction.connect();
		
		
		

		String sql="select * from votant where login='"+login+"' and pass='"+pass+"'";
		ResultSet rs = DBInteraction.Select(sql);
		
		try {
			if(rs.next())
			{
				Votant p=new Votant(rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
				p.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
	


        
        
        
		DBInteraction.disconnect();
		return u;
	
}


}
