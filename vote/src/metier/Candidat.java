package metier;

public class Candidat {
	private int id_candidats;
	private String nom_c,prenom_c,partie_c;
	private int nbr_votes;
	private byte[] image_c;
	
	

	public Candidat(String nom_c, String prenom_c, String partie_c, int nbr_votes, byte[] image_c) {
		super();
		this.nom_c = nom_c;
		this.prenom_c = prenom_c;
		this.partie_c = partie_c;
		this.nbr_votes = nbr_votes;
		this.image_c = image_c;
	}

	public byte[] getImage_c() {
		return image_c;
	}

	public void setImage_c(byte[] image_c) {
		this.image_c = image_c;
	}
	
	public Candidat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Candidat(String nom_c, String prenom_c, String partie_c) {
		super();
		this.nom_c = nom_c;
		this.prenom_c = prenom_c;
		this.partie_c = partie_c;
	}

	public Candidat(int id_candidats, String nom_c, String prenom_c, String partie_c, int nbr_votes) {
		super();
		this.id_candidats = id_candidats;
		this.nom_c = nom_c;
		this.prenom_c = prenom_c;
		this.partie_c = partie_c;
		this.nbr_votes = nbr_votes;
	}
	public Candidat(String nom_c, String prenom_c, String partie_c, int nbr_votes) {
		super();
		this.nom_c = nom_c;
		this.prenom_c = prenom_c;
		this.partie_c = partie_c;
		this.nbr_votes = nbr_votes;
	}
	
	public Candidat(int nbr_votes) {
		super();
		this.nbr_votes = nbr_votes;
	}

	public int getId_candidats() {
		return id_candidats;
	}
	public void setId_candidats(int id_candidats) {
		this.id_candidats = id_candidats;
	}
	public String getNom_c() {
		return nom_c;
	}
	public void setNom_c(String nom_c) {
		this.nom_c = nom_c;
	}
	public String getPrenom_c() {
		return prenom_c;
	}
	public void setPrenom_c(String prenom_c) {
		this.prenom_c = prenom_c;
	}
	public String getPartie_c() {
		return partie_c;
	}
	public void setPartie_c(String partie_c) {
		this.partie_c = partie_c;
	}
	public int getNbr_votes() {
		return nbr_votes;
	}
	public void setNbr_votes(int nbr_votes) {
		this.nbr_votes = nbr_votes;
	}
	

}
