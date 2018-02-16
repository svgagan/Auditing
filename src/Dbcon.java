import java.sql.Connection;
import java.sql.DriverManager;


public class Dbcon 
{
	static Connection con;
	public Connection getConnection()
	{
		try
		{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("jdbc:odbc:privacy");
		System.out.println("Connected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
		
	}

}
