package entity;

import java.time.LocalDate;

public class Teacher extends Staff {
	static long id = 0;

	public Teacher(
			String firstName, String lastName,
			LocalDate birthDay, String department) {
		super(firstName, lastName, birthDay, department);
		id++;
		this.department = department;

	}

	@Override
	public String toString() {
		return "Teacher{" +
				"department='" + department + '\'' +
				", id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", birthDay=" + birthDay +
				'}';
	}
}
