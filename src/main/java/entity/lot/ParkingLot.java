package entity.lot;

import entity.slot.ParkingSlot;

public abstract class ParkingLot {
	private static long counter = 0;
	private final long id;

	public ParkingLot() {
		id = counter++;
	}

	/**
	 * Constructs an empty list with the specified initial capacity. The
	 * purpose of these slots will be configured later.
	 *
	 * @param capacity number of unknown slots to init
	 */
	public ParkingLot(int capacity) {
		id = counter++;

	}

	public abstract boolean add(ParkingSlot parkingSlot);
}
