package carDismantling;

import java.sql.SQLException;

import wares.Car;

public class DismantleProcess {
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		//method observing for car to come in, replaced by generic car here
		Car car = new Car(555, "Car");
		CarDismantle d1 = new CarDismantle(car, 0);
		d1.start();
	}
}
