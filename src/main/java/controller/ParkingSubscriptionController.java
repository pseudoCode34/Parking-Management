package controller;

import entity.Staff;
import entity.Vehicle;
import javafx.util.Pair;

import java.util.Comparator;
import java.util.TreeSet;

public class ParkingSubscriptionController {

    TreeSet<Pair<Staff, Vehicle>> subscriptionList = new TreeSet<>(
            Comparator.comparing(pair -> pair.getValue().getLicensePlate())
    );

    public ParkingSubscriptionController() {

    }

    public void checkUserExisted(Staff staff) {}

    public void checkVehicleSubscribed(Vehicle vehicle) {}

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

    private void removeStaffByID() {
        // TODO: If not existed, throw AttemptToRemoveStaffNotExistException
    }

    // TODO: What if one wants to downgrade his subscription from VIP to normal?
    public void updateContactInfoOf(Staff staff) {}

    public void updateVehicleInfo(Vehicle vehicle) {}

    public String findVehicleByPlate(String wantedPlate) {
        return subscriptionList.stream()
                               .filter(pair -> pair.getValue()
                                                   .getLicensePlate()
                                                   .equals(wantedPlate))
                               .findFirst()
                               .map(Pair::getValue)
                               .map(Vehicle::getLicensePlate)
                               .orElse(null);
    }
}