package sOLID_Principle_L;

public class ElectricCar implements ElectricalVehicle {

	@Override
	public void speed() {
		System.out.println("Speed up with electric car...");
	}

	@Override
	public void chargeBattery() {
		System.out.println("Charging the battery...");
	}
}
