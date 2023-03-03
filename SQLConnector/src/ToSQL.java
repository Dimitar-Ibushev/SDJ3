import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;


public class ToSQL { 
	Connection conn;
	private String url = "den1.mssql8.gear.host";
	private String username = "SEP4";
	private String password = "Hs484fFK~82_";
	Date now = new Date();
	java.sql.Date sqlDate = new java.sql.Date(now.getTime()); 
	public ToSQL() throws SQLException, ClassNotFoundException{
	//	Class.forName("com.sql.Driver"); 

		conn = DriverManager.getConnection(url, username, password);
	}
	
	public void sendReadings(int id, double humidity, double co2, double temp) throws SQLException
	{
		//insert into Measurement values(GETDATE(), 'CO2', 15.10, 1)
		String insertStatement = "INSERT INTO \"Measurement\".readings (1, 2, 3, 4, 5) VALUES (?,?,?,?,?)";
		PreparedStatement statement = conn.prepareStatement(insertStatement);
		statement.setInt(1, id);
		statement.setDouble(2, humidity);
		statement.setDouble(3, co2);
		statement.setDouble(4, temp);
		statement.setDate(5, sqlDate);
		statement.executeUpdate();
		System.out.println("Readings posted");
	}
}
