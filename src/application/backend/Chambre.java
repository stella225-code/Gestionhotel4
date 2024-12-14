package application.backend;

public class Chambre {

    private Integer idchambre;
	private String typechambre;
	private String statutchambre;
	private Double prixchambre;
	
	
	public Chambre(Integer idchambre, String typechambre, String statutchambre, Double prixchambre) {
		super();
		this.idchambre = idchambre;
		this.typechambre = typechambre;
		this.statutchambre = statutchambre;
		this.prixchambre = prixchambre;
	}


	public Chambre() {
		// TODO Auto-generated constructor stub
	}


	public Chambre(String string, String string2, String string3, String string4) {
		// TODO Auto-generated constructor stub
	}


	public Integer getIdchambre() {
		return idchambre;
	}


	public void setIdchambre(Integer idchambre) {
		this.idchambre = idchambre;
	}


	public String getTypechambre() {
		return typechambre;
	}


	public void setTypechambre(String typechambre) {
		this.typechambre = typechambre;
	}


	public String getStatutchambre() {
		return statutchambre;
	}


	public void setStatutchambre(String statuschambre) {
		this.statutchambre = statuschambre;
	}


	public Double getPrixchambre() {
		return prixchambre;
	}


	public void setPrixchambre(Double prixchambre) {
		this.prixchambre = prixchambre;
	}


	public void setIdchambre(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setPrixchambre(String string) {
		// TODO Auto-generated method stub
		
	}


	
	

}
