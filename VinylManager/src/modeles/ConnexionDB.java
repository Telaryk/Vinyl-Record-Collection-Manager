package modeles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDB {
	
	public static Connection Con ;
	static Statement St ;

	public ConnexionDB(){
		
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mydb";
		String login="root";
		String pswd="root";
		        
		try
		   {
		       	Class.forName(driver);
		       	System.out.println("Driver OK");
		   }
		catch(ClassNotFoundException E)
	    	{
				System.out.println("Probleme de chargement de driver");
	    	}
		try
		    {
		        Con = DriverManager.getConnection(url,login ,pswd );
		        System.out.println("Connexion etablie");
		    }
		catch(SQLException E)
		    {
		        System.out.println("Probleme de connexion");
		    }
				
	}

}
