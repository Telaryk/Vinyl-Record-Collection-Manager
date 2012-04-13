package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecordModele {

	private PreparedStatement st = null;
	private ResultSet rs = null;
	
	public ArrayList<Record> RecupListOfRecord(String name){
		
		ArrayList<Record> arrayOfRecord = new ArrayList<Record>();
		
		try {
		st = ConnexionDB.Con.prepareStatement("select * from Record where name=?");
		st.setString(1, name);
		
		rs = st.executeQuery();
		
		while (rs.next()) {
			Record record = new Record();
			
			record.setId(rs.getInt("id"));
			record.setName(rs.getString("name"));
			record.setMatrix_number(rs.getString("matrix_number"));
			record.setPressInfo_id(rs.getString("presse"));
			record.setTypeRecord_id(rs.getInt("idtype"));
			record.setVinyleSize_id(rs.getString("size"));
			record.setClassement(rs.getInt("classement"));

			arrayOfRecord.add(record);
		}
		
		return arrayOfRecord;
		
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
		return null;
		
	}
	
}
