package entity.vehicle;

import java.text.NumberFormat;
import java.util.Locale;

public abstract class Vehicle {
	private String licensePlate;
	private String manufacturer;

	public Vehicle(String licensePlate, String manufacturer) {
		// TODO: Validate vehicle info.
		this.licensePlate = licensePlate;
		this.manufacturer = manufacturer;
	}

	public Vehicle(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public int hashCode() {
		int result = licensePlate != null ? licensePlate.hashCode() : 0;
		result = 31 * result + (manufacturer != null ?
				manufacturer.hashCode() :
				0);
		return result;
	}

	@Override
	public String toString() {
		NumberFormat vndFormat = formatVNDCurrency();
		return "Vehicle{" +
				", licensePlate='" + licensePlate + '\'' +
				", dailyParkingFee=" + vndFormat.format(getDailyParkingFee()) +
				'}';
	}

	private static NumberFormat formatVNDCurrency() {
		Locale vn = new Locale("vi", "VN");
		return NumberFormat.getCurrencyInstance(vn);
	}

	public abstract long getDailyParkingFee();
	public abstract long getMonthlyParkingFee();
	public abstract long getAnnuallyParkingFee();
	public abstract long getLifeTimeParkingFee();
}