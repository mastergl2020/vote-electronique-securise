package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInteraction {

	static String url="jdbc:mysql://localhost/vote";
	static Connection con;
	static Statement st;

	public static  void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, "root", "");
		st = con.createStatement();	
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}

	}

public static void disconnect()
{
	try {
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	}

public static int Maj(String sql)
{
	int n = 0;
	try {
		n = st.executeUpdate(sql);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return n;
}

public static ResultSet Select(String sql)
{
	ResultSet rs = null;
	try {
		rs = st.executeQuery(sql);
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	return rs;
}



}
