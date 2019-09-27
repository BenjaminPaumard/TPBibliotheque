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
 * Servlet implementation class ListLivreUserServlet
 */
@WebServlet("/ListLivreUser")
public class ListLivreUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLivreUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		List<User> users = UserDao.getAllUsers();
		User u = null;
		for(User user : users) {
			if (user.getUsername().equals(username)) {
				
				u = user;
			}
		}
		//User u = UserDao.findUserByUsername(username);
		
		List<Livre> livres = u.getLivrePossede();
		if (!livres.isEmpty()) {
			request.setAttribute("livres", livres);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/listLivre.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
