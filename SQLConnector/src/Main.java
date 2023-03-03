import java.sql.SQLException;

//import com.google.gson.Gson;

public class Main {
	private static ToSQL sql;
	//private static ToEmbedded emb;
	//Gson gson = new Gson();
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		try {
			sql = new ToSQL();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		//emb = new ToEmbedded();
		
		sql.sendReadings(123456, 10.3, 12.2, 24.5);
		System.out.println("A");
		
	}
}
