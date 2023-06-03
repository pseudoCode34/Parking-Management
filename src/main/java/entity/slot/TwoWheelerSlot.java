package entity.slot;

import entity.vehicle.Vehicle;

public class TwoWheelerSlot extends ParkingSlot {
	/**
	 * @param vehicle
	 *
	 * @return
	 */
	@Override
	public boolean park(Vehicle vehicle) {
		if (vehicle == null) return false;

		updateStatusTo(SlotStatus.PAKRED);
		this.managedVehicle = vehicle;

		return true;
	}
}
