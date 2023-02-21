package partPackaging;

import java.sql.SQLException;
import java.util.ArrayList;

import carRegistering.FacilityDB;
import wares.Part;

	public class Packing extends Thread {
		FacilityDB db;
		int type;
		ArrayList<Part> parts;
		Thread t;
		
		
		public Packing(int type) throws SQLException, ClassNotFoundException
		{
			db = new FacilityDB();
			this.type = type;
			parts = new ArrayList<>();
		}
		
		public void run()
		{
				
				try 
				{
					db.packUpSame(type);
					parts = db.packUpSame(type);
					System.out.println(parts);
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			finally 
			{ 
				System.out.println("Packaged!");
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


