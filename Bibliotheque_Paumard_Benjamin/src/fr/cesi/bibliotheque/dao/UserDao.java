package fr.cesi.bibliotheque.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.cesi.bibliotheque.object.User;

public class UserDao {
	private static List<User> users = new ArrayList<User>();
	private static Long idSequence = 1L;
	
private UserDao() { }
	
	public static void addUser(User user) {
		user.setId(idSequence++);
		users.add(user);
	}
	
	public static void removeUser(User user) {
		removeUser(user.getUsername());
	}
	
	public static void removeUser(String username) {
		int index = getUserIndexByUsername(username);
		users.remove(index);
		
	}
	
	private static int getUserIndexByUsername(String username) {
		for (int i = 0; i < users.size(); i++) {
			User user = users.get(i);
			if(user.getUsername().equals(username)) {
				return i;
			}
		}
		return -1;
	}
	
	public static List<User> getAllUsers() {
		return Collections.unmodifiableList(users);
	}
	
	public static User findUserByUsername(String username) {
		int index = getUserIndexByUsername(username);
		User user = users.get(index);
		return user;
	}
	
	public static void updateUser(User user) {
		int index = getUserIndexByUsername(user.getUsername());
		users.set(index, user);
	}
}
