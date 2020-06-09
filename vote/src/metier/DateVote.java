package metier;

import java.sql.Date;

public class DateVote {
	private int id_d;
	private String debut;
	private String fin;
	public DateVote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId_d() {
		return id_d;
	}

	public void setId_d(int id_d) {
		this.id_d = id_d;
	}

	public DateVote(String debut, String fin) {
		super();
		this.debut = debut;
		this.fin = fin;
	}
	public String getDebut() {
		return debut;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	

}
