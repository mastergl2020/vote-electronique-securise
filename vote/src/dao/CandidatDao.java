package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import metier.Candidat;
import metier.Votant;
import util.DBInteraction;

public class CandidatDao {
	/***********************************************Ajouter un Candidat********************************/
	public int AddCandidat(Candidat p) {

		DBInteraction.connect();
		String sql="insert into candidat(nom_c,prenom_c,partie_c,nbr_votes) values('"+p.getNom_c()+"','"+p.getPrenom_c()+"','"+p.getPartie_c()+"','"+p.getNbr_votes()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
	public int AddCandidat1(Candidat p) {

		DBInteraction.connect();
		String sql="insert into candidat(nom_c,prenom_c,partie_c,nbr_votes,image_c) values('"+p.getNom_c()+"','"+p.getPrenom_c()+"','"+p.getPartie_c()+"','"+p.getNbr_votes()+"','"+p.getImage_c()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
/******************************************************************************************************/
	public int updateCandidat(int id, Candidat p) {
		DBInteraction.connect();
		String sql="update candidat set nom_c='"+p.getNom_c()+"'prenom_c='"+p.getPrenom_c()+"'partie_c='"+p.getPartie_c()+"'nbr_votes='"+p.getNbr_votes()+"' where id_candidats='"+id+"'";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
	
/***********************************AJouter les para************************************************/
	
	public int AddCandidat(String nom_c, String prenom_c,String partie_c,int nbr_votes) {
		DBInteraction.connect();
		String sql="insert into candidat(nom_c,prenom_c,partie_c,nbr_votes) values('"+nom_c+"','"+prenom_c+"','"+partie_c+"','"+nbr_votes+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;	}
/*********************************************Recherche Candidat*********************************/
	
	public Candidat FindCandidat(int id_candidats) {
		
		Candidat p=null;
		DBInteraction
		.connect();
		String sql="select * from candidat where id_candidats="+id_candidats;
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				p=new Candidat(rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
				p.setId_candidats(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		return p;
	}
/************************************Supprimer Candidat***************************************/
	
	public int deleteCandidat(String nom_c) {
		DBInteraction.connect();
		String sql="delete from candidat where nom_c='"+nom_c+"'";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;	
	}
/**************************************modifier Dociment************************************/

/***********************************Consulter Candidat***************************************/
	
	public ArrayList<Candidat> AllCandidat() {
		ArrayList<Candidat> ps=new ArrayList<>();
		DBInteraction.connect();
		String sql="select * from candidat ";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			while(rs.next())
			{
				Candidat p=new Candidat(rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5));
				p.setId_candidats(rs.getInt(1));
				ps.add(p);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		
		return ps;
	}
/****************************************************Auth***************************************************************/

}
