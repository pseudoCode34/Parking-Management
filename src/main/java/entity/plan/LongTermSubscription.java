package entity.plan;

import entity.slot.ParkingSlot;
import entity.user.Staff;

public class LongTermSubscription extends ParkingPlan {
	Staff subscriber;
	SubscriptionType type;

	public LongTermSubscription(
			ParkingSlot slot,
			long unitPrice,
			Staff subscriber,
			SubscriptionType type) {
		super(slot, unitPrice);
		this.subscriber = subscriber;
		this.type = type;
	}

	@Override
	public String toString() {
		return "LongTermSubscription{" +
				"subscriber=" + subscriber +
				", type=" + type +
				"} " + super.toString();
	}
}
