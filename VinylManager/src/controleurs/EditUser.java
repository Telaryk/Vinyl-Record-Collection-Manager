package controleurs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeles.ConnexionDB;
import modeles.EditUserModele;
import modeles.InscriptionModele;
import modeles.User;

public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> liste = null;
	
	public EditUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void init() throws ServletException {
		@SuppressWarnings("unused")
		ConnexionDB conn = new ConnexionDB();
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int idUser;
		ArrayList<User> liste = (ArrayList<User>) session.getAttribute("listes");
		idUser = liste.get(0).getIdUser();
		
		EditUserModele e = new EditUserModele();
		
		User u = new User();
		u = e.AfficheLoggedUser(idUser);
		
		request.setAttribute("user", u);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int idUser;
		ArrayList<User> liste = (ArrayList<User>) session.getAttribute("listes");
		idUser = liste.get(0).getIdUser();
		
		EditUserModele eu = new EditUserModele();
		
		String spseudo = request.getParameter("pseudo");
		String semail = request.getParameter("email");
		String sprenom = request.getParameter("prenom");
		String snom = request.getParameter("nom");
		
		User u = new User();
		u.setIdUser(idUser);
		u.setPseudo(spseudo);
		u.setEmail(semail);
		u.setPrenom(sprenom);
		u.setNom(snom);
		
		try {
			eu.ModifUser(u, idUser);
			liste.clear();
			liste.add(u);
			session.setAttribute("listes", liste);
			
			request.setAttribute("user", u);
			request.getRequestDispatcher("profilUser.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
