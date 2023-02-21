package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface ServerInterface extends Remote{
	int getChassis(int reg) throws RemoteException, SQLException;
}
