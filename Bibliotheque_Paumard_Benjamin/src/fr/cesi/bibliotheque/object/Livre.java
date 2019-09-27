package fr.cesi.bibliotheque.object;

public class Livre {
	
	private Long id;
	
	private String titre;
	
	private String auteur;
	
	public Livre(String titre, String auteur) {
		this.titre = titre;
		this.auteur = auteur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

}
