package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.ServerInterface;


public class Client {
	private Client()
	{

	};
	
	public static void main(String[] args)
	{
		
		String host = (args.length < 1) ? null : args[0];
		try
		{
			Registry reg = LocateRegistry.getRegistry(host);
			ServerInterface stub = (ServerInterface) reg.lookup("ServerInterface");
			int response = stub.getChassis(1);
			System.out.println("response: " + response);
		}
		catch (Exception e)
		{	
			e.printStackTrace();
		}
		
		
	}
}
