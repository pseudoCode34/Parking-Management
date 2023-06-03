package controller;

import entity.plan.LongTermSubscription;
import entity.plan.SubscriptionType;
import entity.slot.ParkingSlot;
import entity.user.Staff;
import entity.vehicle.Vehicle;
import javafx.util.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.TreeSet;

public class ParkingSubscriptionController {
	//TODO: Convert Pair to Ticket Class containing Car, User, price?
	TreeSet<Pair<Staff, Vehicle>> subscriptionList = new TreeSet<>(
			Comparator.comparing(pair -> pair.getValue().getLicensePlate()));

	public ParkingSubscriptionController() {}

	@Contract("_, _, _, _ -> new")
	public static @NotNull LongTermSubscription exportTicketFor(
			Vehicle vehicle,
			ParkingSlot slot,
			Staff subscriber,
			SubscriptionType type) {
		slot.park(vehicle);

		switch (type) {
			case MONTHLY -> {
				long monthlyFee = vehicle.getMonthlyParkingFee();
				return new
						LongTermSubscription(
						slot,
						monthlyFee,
						subscriber,
						type);
			}
			case ANNUALLY -> {
				long annuallyFee = vehicle.getAnnuallyParkingFee();
				return new LongTermSubscription(
						slot,
						annuallyFee,
						subscriber,
						type);
			}
			case LIFE_TIME -> {
				long lifeTimeFee = vehicle.getLifeTimeParkingFee();
				return new
						LongTermSubscription(
						slot,
						lifeTimeFee,
						subscriber,
						type);
			}
			default -> throw new RuntimeException("Unreachable path");
		}
	}

	public void createNewSubscription(Staff newStaff, Vehicle vehicle) {
		// TODO: Verify user and vehicle first. If both inputs existed, throw
		//  StaffAlreadySubscribedThisVehicleException. If duplicate vehicle
		//  only, but different user, throw VehicleCanSubscribeOnceException.

		// TODO: If staff is a teacher in a school, set daily subscription
		//  fee to 0. Is it necessary to limit his/her parking lot to a
		//  special one?
		subscriptionList.add(new Pair<>(newStaff, vehicle));
	}

	public void unsubscribeOneVehicle(Vehicle withdrawnVehicle) {
		checkVehicleSubscribed(withdrawnVehicle);

		// TODO: Delete 1 vehicle from subscriptionList means delete all
		//  pairs of (Staff, vehicle) containing *unwantedVehicle. As 1 user
		//  has many vehicles, but only one vehicle is possessed by 1 user.

		removeVehicleByID();
	}

	public void checkVehicleSubscribed(Vehicle vehicle) {}

	private void removeVehicleByID() {
		// TODO: If not existed, throw AttemptToRemoveVehicleNotExistException

	}

	public void removeOneStaff(Staff leavingStaff) {
		checkUserExisted(leavingStaff);

		// TODO: Delete 1 vehicle from subscriptionList means delete all
		//  pairs of (Staff, vehicle) containing *leavingStaff. As 1 user
		//  has many vehicles, but only one vehicle is possessed by 1 user.

		removeStaffByID();
	}

	public void checkUserExisted(Staff staff) {}

	private void removeStaffByID() {
		// TODO: If not existed, throw AttemptToRemoveStaffNotExistException
	}

	// TODO: What if one wants to downgrade his subscription from VIP to
	//  normal?
	public void updateContactInfoOf(Staff staff) {}

	public void updateVehicleInfo(Vehicle vehicle) {}

	public String findVehicleByPlate(String wantedPlate) {
		return subscriptionList.stream()
		                       .filter(pair -> pair.getValue()
		                                           .getLicensePlate()
		                                           .equals(wantedPlate))
		                       .findAny()
		                       .map(Pair::getValue)
		                       .map(Vehicle::getLicensePlate)
		                       .orElse(null);
	}
}