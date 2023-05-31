package entity;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;

public class Vehicle {
    VehicleType type;
    String licensePlate;
    String manufacturer;

    public Vehicle(VehicleType type, String licensePlate, String manufacturer) {
        // TODO: Validate vehicle info.
        this.type = type;
        this.licensePlate = licensePlate;
        this.manufacturer = manufacturer;
    }

    public Vehicle(VehicleType type, String licensePlate) {
        this.type = type;
        this.licensePlate = licensePlate;
    }

    private static NumberFormat formatVNDCurrency() {
        Locale vn = new Locale("vi", "VN");
        return NumberFormat.getCurrencyInstance(vn);
    }

    public long getDailyParkingFee() {
        // FIXME: Is this appropriate to set dailyFee here? Or should it be
        //  set in ParkingSubscriptionController?
        return switch (type) {
            case CAR -> 5000;
            case BIKE -> 2000;
            case MOTORBIKE -> 4000;
            case NOCHARGEDFEE -> 0;
        };
    }

    @Override
    public String toString() {
        NumberFormat vndFormat = formatVNDCurrency();
        return "Vehicle{" +
                "type=" + type +
                ", licensePlate='" + licensePlate + '\'' +
                ", dailyParkingFee=" + vndFormat.format(getDailyParkingFee()) +
                '}';
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (type != vehicle.type) return false;
        if (!licensePlate.equals(vehicle.licensePlate)) return false;
        return Objects.equals(manufacturer, vehicle.manufacturer);
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + licensePlate.hashCode();
        result = 31 * result + (manufacturer != null ?
                manufacturer.hashCode() : 0);
        return result;
    }
}