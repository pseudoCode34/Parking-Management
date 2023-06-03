package entity.plan;

import entity.slot.ParkingSlot;

import java.time.LocalDateTime;

public abstract class ParkingPlan {
	private static long counter = 0; //internal
	private long id = 0; //internal

	public ParkingPlan(ParkingSlot slot, long unitPrice) {
		this.id = counter++;
		exportedOn = LocalDateTime.now();
		// TODO: Remove
		this.parkedIn = slot;
		this.unitPrice = unitPrice;
	}

	private long unitPrice = 0; //internal
	private LocalDateTime exportedOn;//internal
	private ParkingSlot parkedIn;

	public LocalDateTime getExportedTime() {return exportedOn;}

	@Override
	public String toString() {
		return "Ticket{" +
				"id=" + id +
				", exportedOn=" + exportedOn +
				", unitPrice=" + unitPrice +
				", parkedIn=" + parkedIn +
				'}';
	}
}
