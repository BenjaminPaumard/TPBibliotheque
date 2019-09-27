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

import fr.cesi.bibliotheque.dao.LivreDao;
import fr.cesi.bibliotheque.dao.UserDao;
import fr.cesi.bibliotheque.object.Livre;
import fr.cesi.bibliotheque.object.User;

/**
 * Servlet implementation class EmpruntLivreServlet
 */
@WebServlet("/EmpruntLivre")
public class EmpruntLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpruntLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String username = request.getParameter("username");
		System.out.println(username);
		List<Livre> livres = LivreDao.getAllLivres();
		Livre l = null;
		for(Livre livre : livres) {
			if(livre.getId().equals(id)) {
				l = livre;
				List<User> users = UserDao.getAllUsers();
				User u = null;
				for(User user : users) {
					if (user.getUsername().equals(username)) {
						System.out.println(l.getTitre());
						System.out.println(user.getUsername());
						user.addLivrePossede(l);
						u = user;
					}
				}
				UserDao.updateUser(u);
				LivreDao.removeLivre(l);
				RequestDispatcher rd = request.getRequestDispatcher("ListUserLivre");
				rd.forward(request, response);
			}
		}
		
	}

}
