package carRegistering;
import java.sql.SQLException;

public class CarEntry {
	 
	 
	 public void Enter(int chassis, String model) throws ClassNotFoundException
	 {
		 try {
			FacilityDB register = new FacilityDB();
			register.insertCarIntoDb(chassis, model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
	 }
}
