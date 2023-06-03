package entity.user;

import java.time.LocalDate;

public abstract class Staff {
	String firstName;
	String lastName;
	LocalDate birthDay;
	String department;

	public Staff(
			String firstName,
			String lastName,
			LocalDate birthDay,
			String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
}
