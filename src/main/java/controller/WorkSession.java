package controller;

import entity.lot.ParkingLot;
import entity.plan.OneTimeParkingTicket;
import entity.slot.ParkingSlot;
import entity.slot.SlotStatus;
import entity.user.SecurityGuard;
import entity.vehicle.Vehicle;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class WorkSession {
	SecurityGuard onDutyGuard;
	Date workDay;
	LocalTime startTime;
	LocalTime endTime;
	ParkingLot parkingLot;

	public WorkSession(
			Date workDay,
			LocalTime startTime,
			LocalTime endTime,
			ParkingLot parkingLot) {
		this.workDay = workDay;
		this.startTime = startTime;
		this.parkingLot = parkingLot;
	}

	/**
	 * Return a ticket valid only within one day for a {@code vehicle} parking
	 * in the specific {@code slot}. First, verify this slot is ready to park
	 * a new vehicle. Then, update status of this slot to {@code notAvailable}
	 * and {@code VehicleType}. Following that, make a purchase logic
	 *
	 * @param slot
	 */
	public OneTimeParkingTicket exportOneTimeTicketFor(
			ParkingSlot slot,
			Vehicle vehicle) throws RuntimeException {
		Objects.requireNonNull(slot);
		// Rmeove
		// if (!slot.isAbleToPark())
//			throw new RuntimeException("Slot Not Available");

		int parkedVehicleHashCode = vehicle.hashCode();
		recordTransaction();

		LocalDateTime today = LocalDateTime.now();
		long ticketFee = vehicle.getDailyParkingFee();
		OneTimeParkingTicket exported = new OneTimeParkingTicket(
				slot,
				ticketFee,
				parkedVehicleHashCode
		);
		slot.updateStatusTo(SlotStatus.PAKRED);

		return exported;
	}

	// TODO: Based on type vehicle and user, give the corresponding fee. Then,
	//  verify this purchase
	private void recordTransaction() {
	}

	// TODO: How to specify that slot in the ParkingLot. As all the slots are
	//  handled by this ParkingLot List
	public boolean allowWithdrawVehicle(OneTimeParkingTicket ticket) {
		// TODO: This just check that this info on the ticket and your vehicle
		//  are correct. But the prerequisite step is to bring this ticket to
		//  the guard in the right place. At this time, his duty is
		//  check this and allow your withdraw.
		Objects.requireNonNull(ticket);
//		if (ticket.hasAllInfoCorrect() && )
		return false;
	}

	@Override
	public String toString() {
		return "WorkSession{" +
				"onDutyGuard=" + onDutyGuard +
				", workDay=" + workDay +
				", startTime=" + startTime +
				", endTime=" + endTime +
				", parkingLot=" + parkingLot +
				'}';
	}
}
