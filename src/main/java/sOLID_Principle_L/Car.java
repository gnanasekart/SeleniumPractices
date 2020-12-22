package sOLID_Principle_L;

public class Car implements NormalVehicle {

	@Override
	public void speed() {
		System.out.println("Speed up the car...");
	}

	@Override
	public void addFuel() {
		System.out.println("Adding fuel to car...");
	}
}
