package controller;

import entity.lot.CarLot;
import entity.lot.TwoWheelerLot;
import entity.slot.CarSlot;
import entity.slot.ParkingSlot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

public class StudentSupportManagement {
	private final ArrayList<CarLot> carLots = new ArrayList<>();
	private final ArrayList<TwoWheelerLot> twoWheelerLots = new ArrayList<>();

	/**
	 * <p>
	 * Call each ParkingLot's findPlace() to get the best result
	 * </p>
	 *
	 * @return the first slot in the nearest parking lot.
	 * //REMOVE
	 */
	public CarSlot findAvailableCarSlotGlobally() {
		// TODO: Ask if user have any demand for other parking lots

		return carLots.stream()
		              .flatMap(carLot -> carLot.getSlots().stream())
		              .filter(ParkingSlot::isAbleToPark)
		              .findFirst()
		              .orElseThrow(() -> new NoSuchElementException(
				              "NoParkingSpaceForCarLeft"));
	}

	/**
	 * Appends the specified carLot to the end of this list.
	 *
	 * @param carLot element to be appended to this list
	 *
	 * @return {@code true} (as specified by {@link Collection#add})
	 */
	public boolean add(CarLot carLot) {
		return carLots.add(carLot);
	}

	/**
	 * Appends the specified TwoWheeler to the end of this list.
	 *
	 * @param twoWheelerLot element to be appended to this list
	 *
	 * @return {@code true} (as specified by {@link Collection#add})
	 */
	public boolean add(TwoWheelerLot twoWheelerLot) {
		return twoWheelerLots.add(twoWheelerLot);
	}

}
