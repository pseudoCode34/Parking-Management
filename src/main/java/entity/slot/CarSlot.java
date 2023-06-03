package entity.slot;

import entity.vehicle.Vehicle;

public class CarSlot extends ParkingSlot {
	public CarSlot() {super();}

//	public CarSlot(CarSlot carSlot) {
//		this(id, status);
//	}


	@Override
	public String toString() {
		return "CarSlot{" +
				"id=" + id +
				", status=" + status +
				", managedVehicle=" + managedVehicle +
				'}';
	}

	@Override
	public boolean park(Vehicle vehicle) {
		if (vehicle == null) return false;

		updateStatusTo(SlotStatus.PAKRED);
		this.managedVehicle = vehicle;

		return true;
	}
}
