package dao;

import java.sql.SQLException;

import metier.CO;
import metier.Votant;
import util.DBInteraction;

public class COdao {
	public int AddCO(CO p) {

		DBInteraction.connect();
		String sql="insert into co(nom_CO,nbr) values('"+p.getNom_co()+"','"+p.getNbr()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
	public int updateCO(String nom, int p) {
		DBInteraction.connect();
		String sql="update co set nom_co='"+nom+"'nbr='"+p+"' where nom_co= "+nom;
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
	public int deleteCO(String nom_co) {
		DBInteraction.connect();
		String sql="delete from co where nom_co='"+nom_co+"'";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;	
	}


}
