package controller;

import entity.plan.OneTimeParkingTicket;
import entity.slot.ParkingSlot;
import entity.vehicle.Vehicle;

public class TicketController {

	private long paidMoney;


	public OneTimeParkingTicket exportTicketFor(
			Vehicle vehicle,
			ParkingSlot slot) {
		long ticketFee = vehicle.getDailyParkingFee();
		slot.park(vehicle);
		int hashedCode = vehicle.hashCode();

		return new OneTimeParkingTicket(slot, ticketFee, hashedCode);
	}

	public boolean isValidToWithdrawFrom(ParkingSlot slot) {
		//	TODO: Put validiation logic related to the external info, i.e, the
		//	 ticket's ownership to TicketController.
		return false;
	}
}
