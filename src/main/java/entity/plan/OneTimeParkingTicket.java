package entity.plan;

import entity.slot.ParkingSlot;
import entity.vehicle.Vehicle;

import java.time.LocalDateTime;

public class OneTimeParkingTicket extends ParkingPlan {
	private int vehicleHashCode;

	public OneTimeParkingTicket(
			ParkingSlot slot,
			long unitPrice,
			int vehicleHashCode) {
		super(slot, unitPrice);
		this.vehicleHashCode = vehicleHashCode;
	}

	/**
	 * Check whether its most fundamental info is valid. Otherwise, it's just
	 * a trash receipt.
	 *
	 * @return {@code true} if user hands in this ticket within its exported
	 * day, the code on the ticket is corresponding to the parking vehicle's
	 */
	public boolean hasAllInfoCorrect(Vehicle vehicle) {
		LocalDateTime today = LocalDateTime.now();
		if (!this.getExportedTime().equals(today)) return false;
		if (this.getVehicleHashCode() != vehicle.hashCode()) return false;

		return true;
	}

	public int getVehicleHashCode() {
		return vehicleHashCode;
	}

	public void setVehicleHashCode(int vehicleHashCode) {
		this.vehicleHashCode = vehicleHashCode;
	}

	@Override
	public String toString() {
		return "OneTimeParkingTicket{" +
				"vehicleHashCode=" + vehicleHashCode +
				"} " + super.toString();
	}
}
