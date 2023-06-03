package entity.lot;

import entity.slot.CarSlot;
import entity.slot.ParkingSlot;

import java.util.ArrayList;

public class CarLot extends ParkingLot {
	ArrayList<CarSlot> slots = new ArrayList<>();

	public CarLot() {}

	/**
	 * Constructs an empty list with the empty elements of specified initial
	 * capacity. The purpose of these slots will be configured later.
	 *
	 * @param capacity number of unknown slots to init
	 */
	public CarLot(int capacity) {
		super(capacity);
//		slots.forEach(CarSlot::new);
	}

	public long availableSlotCounter() {
		return slots.stream()
		            .map(ParkingSlot::isAbleToPark)
		            .count();
	}

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param parkingSlot element to be appended to this list
	 *
	 * @return {@code true} (as specified by {@link Collection#add})
	 */
	@Override
	public boolean add(ParkingSlot parkingSlot) {
		return slots.add((CarSlot) parkingSlot);
	}

	public ArrayList<CarSlot> getSlots() {
		return slots;
	}
}
