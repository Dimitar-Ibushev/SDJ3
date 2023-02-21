package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import javax.jws.WebService;

import carRegistering.FacilityDB;

public class Server implements ServerInterface{
	FacilityDB db;
	public Server() throws ClassNotFoundException, SQLException
	{
		db = new FacilityDB();
		WebService service;
	}
	
	
	public int getChassis(int reg) throws SQLException
	{
		return db.getCarForPart(reg);
	}
	
	public static void main(String args[])
	{
		try
		{
			Server obj = new Server();
			ServerInterface stub = (ServerInterface) UnicastRemoteObject.exportObject(obj, 0);
			
			Registry reg = LocateRegistry.getRegistry();
			reg.bind("ServerInterface", stub);
		
		
		System.out.println("Server up");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
