
package JUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserRegistrationTest {

    private UserRegistration validator;

    @BeforeEach
    void setUp() {
        validator = new UserRegistration();
    }

    /*
     * UC10: Write JUnit tests for user registration.
     * Test happy and sad cases for first name, last name,
     * email, mobile number and password.
     */

    // First Name Tests

    @Test
    void firstNameHappyTest() {
        assertTrue(validator.validateFirstName("Angira"));
    }

    @Test
    void firstNameSadTest() {
        assertFalse(validator.validateFirstName("an"));
    }

    // Last Name Tests

    @Test
    void lastNameHappyTest() {
        assertTrue(validator.validateLastName("Yadav"));
    }

    @Test
    void lastNameSadTest() {
        assertFalse(validator.validateLastName("yadav"));
    }

    // Email Tests

    @Test
    void emailHappyTest() {
        assertTrue(validator.validateEmail("abc.xyz@bl.co.in"));
    }

    @Test
    void emailSadTest() {
        assertFalse(validator.validateEmail("abc@.com"));
    }

    // Mobile Number Tests

    @Test
    void mobileHappyTest() {
        assertTrue(validator.validateMobile("91 9919819801"));
    }

    @Test
    void mobileSadTest() {
        assertFalse(validator.validateMobile("919919819801"));
    }

    // Password Tests

    @Test
    void passwordHappyTest() {
        assertTrue(validator.validatePassword("Abcd123@"));
    }

    @Test
    void passwordSadTest() {
        assertFalse(validator.validatePassword("abcd1234"));
    }


    /*
     * UC11: Parameterized tests for multiple email addresses.
     * Test all valid and invalid samples provided in the assignment.
     */

    // Valid Email Samples

    @ParameterizedTest
    @ValueSource(strings = {
            "abc@yahoo.com",
            "abc-100@yahoo.com",
            "abc.100@yahoo.com",
            "abc111@abc.com",
            "abc-100@abc.net",
            "abc.100@abc.com.au",
            "abc@1.com",
            "abc@gmail.com.com",
            "abc+100@gmail.com"
    })
    void validEmailSamplesTest(String email) {
        assertTrue(
                validator.validateEmail(email),
                "Expected valid email: " + email
        );
    }

    // Invalid Email Samples

    @ParameterizedTest
    @ValueSource(strings = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
    })
    void invalidEmailSamplesTest(String email) {
        assertFalse(
                validator.validateEmail(email),
                "Expected invalid email: " + email
        );
    }
}
