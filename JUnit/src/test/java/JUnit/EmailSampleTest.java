
package JUnit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Problem: Validate multiple email addresses using JUnit Parameterized Tests.
 * Test all valid and invalid email samples provided in the assignment.
 */

public class EmailSampleTest {

    private final UserRegistration validator = new UserRegistration();

    // Test all valid email samples.

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
    void validEmailTest(String email) {

        assertTrue(
                validator.validateEmail(email),
                "Expected valid email: " + email
        );
    }

    // Test all invalid email samples.

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
    void invalidEmailTest(String email) {

        assertFalse(
                validator.validateEmail(email),
                "Expected invalid email: " + email
        );
    }
}
