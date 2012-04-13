package modeles;

public class Record {
	
	private int id;
	private String matrix_number;
	private String presse;
	private int idtype;
	private String size;
	private String name;
	private int classement;
	
	public String getMatrix_number() {
		return matrix_number;
	}
	public void setMatrix_number(String matrixNumber) {
		matrix_number = matrixNumber;
	}
	public String getPressInfo() {
		return presse;
	}
	public void setPressInfo_id(String presse) {
		this.presse = presse;
	}
	public int getTypeRecord_id() {
		return idtype;
	}
	public void setTypeRecord_id(int typeRecordId) {
		idtype = typeRecordId;
	}
	public String getVinyleSize() {
		return size;
	}
	public void setVinyleSize_id(String vinyleSize) {
		size = vinyleSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClassement() {
		return classement;
	}
	public void setClassement(int classement) {
		this.classement = classement;
	}

}
