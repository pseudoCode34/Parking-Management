package entity.slot;

import entity.vehicle.Vehicle;

public abstract class ParkingSlot implements Parkable{
	private static long counter = 0;
	protected final long id;
	protected SlotStatus status = SlotStatus.UNAVAILABLE;
	protected Vehicle managedVehicle;

	public ParkingSlot() {
		this.id = counter++;
	}

	@Override
	public String toString() {
		return "ParkingSlot{" +
				"id=" + id +
				", isAvailable=" + status +
				'}';
	}

	public SlotStatus getStatus() {
		return status;
	}

	public void updateStatusTo(SlotStatus status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public final boolean isAbleToPark() {
		return status == SlotStatus.EMPTY;
	}

}
