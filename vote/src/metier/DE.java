package metier;

public class DE {
	private int id_de;
	private String name_c;
	private String login_v ;
	public DE() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DE(int id_de, String name_c, String login_v) {
		super();
		this.id_de = id_de;
		this.name_c = name_c;
		this.login_v = login_v;
	}
	public DE(String name_c, String login_v) {
		super();
		this.name_c = name_c;
		this.login_v = login_v;
	}
	public int getId_de() {
		return id_de;
	}
	public void setId_de(int id_de) {
		this.id_de = id_de;
	}
	public String getName_c() {
		return name_c;
	}
	public void setName_c(String name_c) {
		this.name_c = name_c;
	}
	public String getLogin_v() {
		return login_v;
	}
	public void setLogin_v(String login_v) {
		this.login_v = login_v;
	}
	
	

}
