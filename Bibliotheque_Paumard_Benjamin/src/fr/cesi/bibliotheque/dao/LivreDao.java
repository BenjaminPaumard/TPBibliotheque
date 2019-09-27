package fr.cesi.bibliotheque.dao;

import fr.cesi.bibliotheque.object.Livre;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LivreDao {
	private static List<Livre> livres = new ArrayList<Livre>();
	private static Long idSequence = 1L;
	
	private LivreDao() { }
	
	public static void addLivre(Livre livre) {
		livre.setId(idSequence++);
		livres.add(livre);
	}
	
	public static void removeLivre(Livre livre) {
		removeLivre(livre.getId());
	}
	
	public static void removeLivre(Long id) {
		int index = getLivreIndexById(id);
		livres.remove(index);
		
	}
	
	private static int getLivreIndexById(Long id) {
		for (int i = 0; i < livres.size(); i++) {
			Livre livre = livres.get(i);
			if(livre.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	public static List<Livre> getAllLivres() {
		return Collections.unmodifiableList(livres);
	}
	
	public static Livre findLivreById(Long id) {
		int index = getLivreIndexById(id);
		Livre product = livres.get(index);
		return product;
	}
}
