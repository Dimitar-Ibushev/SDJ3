package jdbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.Driver;

public class Select
{
   public static void main(String[] args) throws SQLException
   {
      DriverManager.registerDriver(new Driver());
      Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgress", "password");
      try
      {
         PreparedStatement statement = connection.prepareStatement("SELECt * FROM test");
         ResultSet rs = statement.executeQuery();
         while(rs.next())
               {
            System.out.println(rs.getString("name"));
               }
      }
      
         finally
         {
            connection.close();
         }
      
   }
}
