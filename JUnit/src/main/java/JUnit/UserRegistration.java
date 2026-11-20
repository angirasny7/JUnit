
package JUnit;

public class UserRegistration {

    // UC1: Validate first name.
    // First letter must be uppercase and minimum length must be 3.
    public boolean validateFirstName(String firstName) {
        return firstName != null &&
                firstName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC2: Validate last name.
    // First letter must be uppercase and minimum length must be 3.
    public boolean validateLastName(String lastName) {
        return lastName != null &&
                lastName.matches("^[A-Z][a-zA-Z]{2,}$");
    }

    // UC3: Validate email address.
    // Supports username, domain, TLD and one optional additional TLD.
    public boolean validateEmail(String email) {

        String emailRegex =
                "^[A-Za-z0-9_+-]+(\\.[A-Za-z0-9_+-]+)*"
                        + "@[A-Za-z0-9]+"
                        + "\\.[A-Za-z]{2,}"
                        + "(\\.[A-Za-z]{2,})?$";

        return email != null && email.matches(emailRegex);
    }

    // UC4: Validate mobile number.
    // Country code followed by a space and exactly 10 digits.
    public boolean validateMobile(String mobile) {
        return mobile != null &&
                mobile.matches("^[0-9]{1,3} [0-9]{10}$");
    }

    // UC5-UC8: Validate password.
    // Minimum 8 characters, at least one uppercase,
    // at least one digit and exactly one special character.
    public boolean validatePassword(String password) {

        String passwordRegex =
                "^(?=.*[A-Z])(?=.*[0-9])(?=.{8,}$)"
                        + "[A-Za-z0-9]*[^A-Za-z0-9][A-Za-z0-9]*$";

        return password != null &&
                password.matches(passwordRegex);
    }
}
