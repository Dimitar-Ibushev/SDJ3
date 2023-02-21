package carDismantling;
import wares.*;
import carRegistering.*;
import java.sql.SQLException;

public class CarDismantle extends Thread{
	int chassis;
	int part1, part2, part3, part4, part5, part6;
	String model;
	FacilityDB db;
	int reg = 0;
	Thread t;
	
	public CarDismantle(Car car, int reg) throws SQLException, ClassNotFoundException
	{
		
		db = new FacilityDB();
		this.reg = reg;
		chassis = car.getcNum();
		model.equals(car.getModel());
	}
	
	public void run()
	{
		try
		{
			for(int i = 1; i >=5; i++)
			{
				int weight = 0;
				switch (i) 
				{
				case 1:
					weight = 20;
					break;
				case 2:
					weight = 60;
					break;
				case 3:
					weight = 50;
					break;
				case 4:
					weight = 35;
					break;
				case 5:
					weight = 44;
					break;
				case 6:
					weight = 55;
					break;

				}
			try 
			{
				db.insertPartIntoDb(reg + i, weight, i, new Car(chassis, model));
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		}
		finally 
		{
			System.out.println("Car Dismantled");
		}
		
	}
	
	public void start()
	{
		if(t == null)
		{
			t = new Thread(this);
			t.start();
		}
	}
	
	
}
