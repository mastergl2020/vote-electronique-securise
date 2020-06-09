package metier;



import com.mysql.jdbc.Blob;

public class Votant {
	private int id;
	private String nom,prenom,login,pass;
	private String statue;
	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Votant(String nom, String prenom, String login, String pass, String statue,byte[] image) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pass = pass;
		this.statue = statue;
		this.image=image;
	}

	public Votant(String nom, String prenom, String login, String pass, String statue) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pass = pass;
		this.statue = statue;
	}

	public String getStatue() {
		return statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

	//private Boolean active;
	public Votant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Votant(String nom, String prenom, String login, String pass) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pass = pass;
	}

	public Votant(int id, String nom, String prenom, String login, String pass) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.pass = pass;
	//this.active = active;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public Votant(String login) {
		super();
		this.login = login;
	}
	
	

}
