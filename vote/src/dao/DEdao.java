package dao;

import metier.DE;
import util.DBInteraction;

public class DEdao {
	public int AddDE(DE p) {

		DBInteraction.connect();
		String sql="insert into de(name_c,login_v) values('"+p.getName_c()+"','"+p.getLogin_v()+"')";
		int n=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return n;
	}

}
