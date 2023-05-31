package entity;

import controller.ParkingSubscriptionController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.TreeSet;

import static entity.VehicleType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {
	static TreeSet<Vehicle> vehiclesOfNKT;
	static Staff existedStaff;
	static Vehicle demoBike;
	ParkingSubscriptionController subscriptionCtl;

	@BeforeEach
	void setUp() {
		subscriptionCtl = new ParkingSubscriptionController();

		subscriptionCtl.createNewSubscription(
				new Teacher(
						"Nothing",
						"special",
						LocalDate.of(2001, 1, 1),
						"Management"),
				new Vehicle(BIKE, "Some random plate"));
		subscriptionCtl.createNewSubscription(
				new Teacher(
						"Random name",
						"Misc",
						LocalDate.of(2009, 12, 12),
						"Computer Science"),
				new Vehicle(CAR, "Another random plate"));
		subscriptionCtl.createNewSubscription(
				existedStaff,
				new Vehicle(MOTORBIKE, "Another random plate")
		);
	}


	@Test
	void modifyOneVehicleInfo() {
		// if
		demoBike = new Vehicle(MOTORBIKE, "Old plate");
		existedStaff = new SecurityGuard(
				"Regular name",
				"Irregular",
				LocalDate.of(2009, 12, 12),
				"Student Support");

		subscriptionCtl = new ParkingSubscriptionController();
		subscriptionCtl.createNewSubscription(
				existedStaff,
				new Vehicle(MOTORBIKE, "Random"));
		subscriptionCtl.createNewSubscription(existedStaff, demoBike);

		// when
		String expected = "Updated Plate";
		demoBike.setLicensePlate(expected);

		// then
		String actual = subscriptionCtl.findVehicleByPlate(expected);
		assertEquals(actual, expected);
	}
}