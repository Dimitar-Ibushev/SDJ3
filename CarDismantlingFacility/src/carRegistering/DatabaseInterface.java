package carRegistering;

import java.sql.SQLException;
import java.util.ArrayList;

import wares.Car;
import wares.Part;

public interface DatabaseInterface {
	void insertCarIntoDb(int chassis, String model)
	throws SQLException;
	
	void removeCarFromDb(int chassis)
	throws SQLException;
	
	Car getCar(int chassis)
	throws SQLException;
	
	void insertPartIntoDb(int reg, int weight, int type, Car car)
	throws SQLException;
	
	void removePartFromDb(int reg)
	throws SQLException;
	
	ArrayList<Part> packUpSame(int type) throws SQLException;
	
	ArrayList<Part> packUpSystem(int system);
	
	int getCarForPart(int reg) throws SQLException;

}
