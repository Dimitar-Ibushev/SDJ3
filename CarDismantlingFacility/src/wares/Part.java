package wares;

public class Part {
	int regNum;
	int weight;
	int type;
	Car car;
	
	public Part(int reg, int type, int chassis, String model)
	{
		regNum = reg;
		this.type = type;
		car = new Car(chassis, model);
		switch (type) {
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
	}
	
	public Car getCar() {
		return car;
	}
	
	public int getRegNum() {
		return regNum;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getType() {
		return type;
	}
	
	
	
}
