package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditUserModele {
	
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
	
	
	public void ModifUser(User u, int id) throws SQLException{
		try{
			st=ConnexionDB.Con.prepareStatement("update mydb.User set username=?, email=?, first_name=?, last_name=?,  where id=?");
			st.setString(1, u.getPseudo());
			st.setString(2, u.getEmail());
			st.setString(3, u.getPrenom());
			st.setString(4, u.getNom());
			st.setInt(6, id);

			st.executeUpdate();
		}
		catch(Exception E){
			System.out.println("Error");
		}
	}
	

}
