package entity.lot;

import entity.slot.ParkingSlot;
import entity.slot.TwoWheelerSlot;

import java.util.ArrayList;

public class TwoWheelerLot extends ParkingLot {
	private ArrayList<TwoWheelerSlot> slots = new ArrayList<>();

	/**
	 * Appends the specified element to the end of this list.
	 *
	 * @param parkingSlot element to be appended to this list
	 *
	 * @return {@code true} (as specified by {@link Collection#add})
	 */
	@Override
	public boolean add(ParkingSlot parkingSlot) {
		return slots.add((TwoWheelerSlot) parkingSlot);
	}

}
