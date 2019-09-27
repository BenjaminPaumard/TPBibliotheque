package fr.cesi.bibliotheque.object;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Long id;
	private String username;
	private String mdp;
	private List<Livre> livrePossede= new ArrayList<Livre>();
	
	public User(String username, String mdp) {
		this.mdp = mdp;
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Livre> getLivrePossede() {
		return livrePossede;
	}

	public void addLivrePossede(Livre livre) {
		System.out.println(livre.getTitre());
		this.livrePossede.add(livre);
	}
	
	public Livre removeLivrePossede(Long id) {
		for (int i = 0; i < livrePossede.size(); i++) {
			Livre livre = livrePossede.get(i);
			if(livre.getId() == id) {
				return livre;
			}
		}
		return null;
	}

}
