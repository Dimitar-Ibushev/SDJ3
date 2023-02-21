package server;

import java.sql.SQLException;

import carRegistering.FacilityDB;

public class ChassisRetriever {
	FacilityDB db;
	public int getChassis(int reg) throws SQLException
	{
		return db.getCarForPart(reg);
	}
}
