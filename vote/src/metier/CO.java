package metier;

public class CO {
	private int id_co;
	private String nom_co;
	private int nbr ;
	public CO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CO(String nom_co) {
		super();
		this.nom_co = nom_co;
	}

	public CO(String nom_co, int nbr) {
		super();
		this.nom_co = nom_co;
		this.nbr = nbr;
	}
	public int getId_co() {
		return id_co;
	}
	public void setId_co(int id_co) {
		this.id_co = id_co;
	}
	public String getNom_co() {
		return nom_co;
	}
	public void setNom_co(String nom_co) {
		this.nom_co = nom_co;
	}
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	

}
