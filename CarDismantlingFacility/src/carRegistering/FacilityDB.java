package carRegistering;

import java.sql.Connection;
import java.sql.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import wares.Car;
import wares.Part;


public class FacilityDB implements DatabaseInterface {
	   private final String url = "jdbc:postgresql://localhost:5432/postgres";
	   private final String username = "postgres";
	   private final String password = "123";
	   private Connection connect;
	   Driver driver;
	   
	   public FacilityDB() throws SQLException, ClassNotFoundException {
		   Class.forName("org.postgresql.Driver");
		   DriverManager.registerDriver(driver);
		   this.connect = DriverManager.getConnection(url, username, password);
		   }

	@Override
	public void insertCarIntoDb(int chassis, String model) throws SQLException {
		String insertStatement = "INSERT INTO \"Facility\".cars (chassis, model) VALUES(?,?)";
		PreparedStatement statement = connect.prepareStatement(insertStatement);
		statement.setInt(1, chassis);
		statement.setString(2, model);
		statement.executeUpdate();
	}

	@Override
	public void removeCarFromDb(int chassis) throws SQLException {
		String deleteStatement = "DELETE FROM \"Facility\".cars WHERE chassis = ?";
		PreparedStatement statement = this.connect.prepareStatement(deleteStatement);
		statement.setInt(1, chassis);
		statement.executeUpdate();
	}

	@Override
	public Car getCar(int chassis) throws SQLException {
		int a = 0;
		String s = "";
		String statement = "SELECT chassis FROM\"Facility\".cars WHERE chassis = ?";
		PreparedStatement selectStatement = connect.prepareStatement(statement);
		selectStatement.setInt(1, chassis);
		ResultSet rs = selectStatement.executeQuery();
		
		while(rs.next())
		{
			 a = rs.getInt(chassis);
		}
		
		statement = "SELECT model FROM\"Facility\".cars WHERE chassis = ?";
		PreparedStatement anotherStatement = connect.prepareStatement(statement);
		anotherStatement.setString(2, "Model");
		ResultSet rs2 = anotherStatement.executeQuery();
		while(rs2.next())
		{
			 s = rs.getString("model");
		}
		
		return new Car(a, s);
				
	}

	@Override
	public void insertPartIntoDb(int reg, int weight, int type, Car car) throws SQLException {
		String insertStatement = "INSERT INTO\"Facility\".parts (reg, weight, type, car) VALUES (?, ?, ? ?)";
		PreparedStatement statement = connect.prepareStatement(insertStatement);
		statement.setInt(1, reg);
		statement.setInt(2, weight);
		statement.setInt(3, type);
		statement.setObject(4, car);
		statement.executeUpdate();
	}

	@Override
	public void removePartFromDb(int reg) throws SQLException {
		String deleteStatement = "DELETE FROM \"Facility\".parts WHERE reg = ?";
		PreparedStatement statement = this.connect.prepareStatement(deleteStatement);
		statement.setInt(1, reg);
		statement.executeUpdate();		
	}

	@Override
	public ArrayList<Part> packUpSame(int type) throws SQLException {
		ArrayList<Part> parts = new ArrayList<Part>();
		int weight = 0;
		while(weight < 200)
		{
			int cycle = 1;
			String statement = "SELECT reg FROM\"Facility\".parts WHERE type = ?";
			PreparedStatement selectStatement = connect.prepareStatement(statement);
			selectStatement.setInt(1, type);
			ResultSet rs = selectStatement.executeQuery();
			
			Part part = new Part(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));
			parts.add(part);
			cycle++;
		}
		return parts;
	}

	@Override
	public ArrayList<Part> packUpSystem(int system) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCarForPart(int reg) throws SQLException {
		Car car = new Car(0, "");
		String statement = "SELECT car FROM\"Facility\".parts WHERE reg = ?";
		PreparedStatement selectStatement = connect.prepareStatement(statement);
		selectStatement.setObject(1, car);
		ResultSet rs = selectStatement.executeQuery();
		car = (Car) rs.getObject(1);
		return car.getcNum();
	}
}
	   
	   

