package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfilUserModele {
	
	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	public User AfficheLoggedUser(int idUser){
		try {
		st = ConnexionDB.Con.prepareStatement("select * from User where id=?");
		st.setInt(1, idUser);
		
		rs = st.executeQuery();
		
		User u = new User();
		
		while (rs.next()) {
			u.setIdUser(rs.getInt("id"));
			u.setPseudo(rs.getString("username"));
			u.setMotDePasse(rs.getString("password"));
			u.setEmail(rs.getString("email"));
			u.setPrenom(rs.getString("first_name"));
			u.setNom(rs.getString("last_name"));
		}
		
		return u;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}

}
