package wares;

public class Car
{
	int cNum = 0;
	String model;
	public Car(int cNum, String model)
	{
		this.cNum = cNum;
		this.model = model;
	}
	
	public int getcNum() 
	{
		return cNum;
	}
	
	public String getModel() 
	{
		return model;
	}
	
	@Override
	public String toString() {
		return "Chassis number: " + cNum + "\nModel: " + model;
	}
}
