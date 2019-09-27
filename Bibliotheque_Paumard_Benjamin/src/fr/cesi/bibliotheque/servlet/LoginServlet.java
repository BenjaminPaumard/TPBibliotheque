package fr.cesi.bibliotheque.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.cesi.bibliotheque.object.User;
import fr.cesi.bibliotheque.dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String mdp = request.getParameter("password");
		User utilisateur = new User(username,mdp);
		String admin = "admin";
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		session.setAttribute("user", username);
		if(username.equals(admin)) {
			if(mdp.equals(admin)) {
				session.setAttribute("admin", "oui");
			}else {
				session.setAttribute("erreur", "mot de passe incorrect");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		}
		List<User> users = UserDao.getAllUsers();
		if(users.isEmpty()){
			System.out.println("premier user");
			UserDao.addUser(utilisateur);
		}else {
			System.out.println("test3");
			for(User user : users) {
				System.out.println("test4");
				if(user.getUsername().equals(username)) {
					System.out.println("update");
					UserDao.updateUser(utilisateur);
				}else {
					System.out.println("add");
					UserDao.addUser(utilisateur);
				}
			}
		}
		System.out.println("test2");
		session.removeAttribute("erreur");
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}
