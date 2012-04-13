package controleurs;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modeles.ConnexionDB;
import modeles.LoginModele;
import modeles.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArrayList<User> liste = null;


	public void init() throws ServletException {
		@SuppressWarnings("unused")
		ConnexionDB conn = new ConnexionDB();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		String lien=request.getParameter("lien");
		
		if(lien != null && lien.equals("logoff")){
			liste.clear();
			session.setAttribute("liste", liste);
			response.sendRedirect("formLogin.jsp");
		} 
		else {
			response.sendRedirect("formLogin.jsp");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		LoginModele l = new LoginModele();

		String user = request.getParameter("pseudo");
		String passe = request.getParameter("motdepasse");

		User u = new User();
		u.setPseudo(user);
		u.setMotDePasse(passe);

		liste = l.RechercheUser(u);
		if (liste.size() != 0) {
			session.setAttribute("listes",liste);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			response.sendRedirect("log_error.jsp");
		}
	}
}
