package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InscriptionModele {
	
	private PreparedStatement st = null;
	private ResultSet rs = null;
	private int i=0;
	
	public InscriptionModele (){
		try{
			st = ConnexionDB.Con.prepareStatement("select * from User");
			rs = st.executeQuery();
			while (rs.next()) {
				if (i==rs.getInt("id")){i++;}
			}
		}
		catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void AjoutUser(User u) throws SQLException{
		try{
			st=ConnexionDB.Con.prepareStatement("insert into mydb.User(id,username,password,email,first_name,last_name) values (?,?,?,?,?,?)");
			st.setInt(1, this.i);
			st.setString(2, u.getPseudo());
			st.setString(3, u.getMotDePasse());
			st.setString(4, u.getEmail());
			st.setString(5, u.getPrenom());
			st.setString(6, u.getNom());

			st.executeUpdate();
		}
		catch(Exception E){
			System.out.println("Error");
		}
	}

}
