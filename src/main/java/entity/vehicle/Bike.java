package entity.vehicle;

public class Bike extends Vehicle {
	public Bike(String licensePlate, String manufacturer) {
		super(licensePlate, manufacturer);
	}

	public Bike(String licensePlate) {
		super(licensePlate);
	}

	@Override
	public final long getDailyParkingFee() {
		return 2_000;
	}

	@Override
	public long getMonthlyParkingFee() {
		return 40_000;
	}

	@Override
	public long getAnnuallyParkingFee() {
		return 450_000;
	}

	@Override
	public long getLifeTimeParkingFee() {
		return 800_000;
	}
}
