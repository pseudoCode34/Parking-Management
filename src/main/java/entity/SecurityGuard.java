package entity;

import java.time.LocalDate;

public class SecurityGuard extends Staff {
    static long id = 0;
    // TODO: what information to specify here for a security guard?


    public SecurityGuard(
            String firstName,
            String lastName,
            LocalDate birthDay,
            String department) {
        super(firstName, lastName, birthDay, department);
        id++;
    }

    @Override
    public String toString() {
        return "SecurityGuard{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}