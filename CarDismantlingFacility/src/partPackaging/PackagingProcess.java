package partPackaging;

import java.sql.SQLException;

public class PackagingProcess {
	public static void main(String args[]) throws SQLException, ClassNotFoundException
	{
		Packing pack = new Packing(1);	
		pack.start();
	}
}
