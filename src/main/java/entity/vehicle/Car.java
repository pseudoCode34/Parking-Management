package entity.vehicle;

public class Car extends Vehicle{
	public Car(String licensePlate, String manufacturer) {
		super(licensePlate, manufacturer);
	}

	public Car(String licensePlate) {
		super(licensePlate);
	}

	@Override
	public final long getDailyParkingFee() {
		return 5000;
	}

	@Override
	public long getMonthlyParkingFee() {
		return 200_000;
	}

	@Override
	public long getAnnuallyParkingFee() {
		return 2_000_000;
	}

	@Override
	public long getLifeTimeParkingFee() {
		return 3_500_000;
	}
}
