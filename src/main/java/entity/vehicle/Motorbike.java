package entity.vehicle;

public class Motorbike extends Vehicle{
	public Motorbike(String licensePlate, String manufacturer) {
		super(licensePlate, manufacturer);
	}

	public Motorbike(String licensePlate) {
		super(licensePlate);
	}
	@Override
	public final long getDailyParkingFee() {
		return 4000;
	}

	@Override
	public long getMonthlyParkingFee() {
		return 100_000;
	}

	@Override
	public long getAnnuallyParkingFee() {
		return 1_000_000;
	}

	@Override
	public long getLifeTimeParkingFee() {
		return 2_000_000;
	}
}
