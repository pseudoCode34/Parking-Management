package controller;

import entity.ParkingLot;
import entity.SecurityGuard;
import entity.Vehicle;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class DutySession {
    // There could be many protectors working at a parking lot simultaneously
    ArrayList<SecurityGuard> onDutyGuards;
    Date workDay;
    LocalTime startTime;
    LocalTime endTime;
    ParkingLot parkingLot;
    ArrayList<Vehicle> parkedVehicles;

    public DutySession(
            ArrayList<SecurityGuard> onDutyGuards,
            Date workDay,
            LocalTime startTime,
            LocalTime endTime,
            ParkingLot parkingLot,
            ArrayList<Vehicle> parkedVehicles) {
        this.onDutyGuards = onDutyGuards;
        this.workDay = workDay;
        this.startTime = startTime;
        this.endTime = endTime;
        this.parkingLot = parkingLot;
        this.parkedVehicles = parkedVehicles;
    }

    public void findPlaceToPark() {
        // TODO: If size > capacity, throw NoParkingSpaceLeftException and ask if user have any demand for other parking lots

        // TODO: What if there's no parking lot left?
    }

    @Override
    public String toString() {
        return "DutySession{" +
                "onDutyGuards=" + onDutyGuards +
                ", workDay=" + workDay +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", parkingLot=" + parkingLot +
                ", parkedVehicles=" + parkedVehicles +
                '}';
    }
}
