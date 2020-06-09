package dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import metier.DateVote;
import util.DBInteraction;

public class DateDao {
	public int AddDateV(DateVote p) {

		DBInteraction.connect();
		String sql="insert into datevote(debut,fin) values('"+p.getDebut()+"','"+p.getFin()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}
	public int deleteDate(int id) {
		DBInteraction.connect();
		String sql="delete from datevote where id_d="+id;
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;	
	}
	public Boolean AllDate() {
		DBInteraction.connect();
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		Calendar calendar = Calendar.getInstance();
		String sql="select * from datevote where fin='"+format.format(calendar.getTime())+"'";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return true;
			
	}

}
