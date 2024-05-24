package com.sheryians.major.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testUserCreation() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        assertEquals("John", user.getFirstName());
        assertEquals("Doe", user.getLastName());
        assertEquals("john.doe@example.com", user.getEmail());

    }

    @Test
    public void testInvalidEmail() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("invalid-email");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());

        for (ConstraintViolation<User> violation : violations) {
            if (violation.getPropertyPath().toString().equals("email")) {
                assertEquals("{errors.invalid_email}", violation.getMessage());
            }
        }
    }

    @Test
    public void testEmptyFirstName() {
        User user = new User();
        user.setFirstName("");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");


        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertFalse(violations.isEmpty());

        for (ConstraintViolation<User> violation : violations) {
            if (violation.getPropertyPath().toString().equals("firstName")) {
                assertEquals("must not be empty", violation.getMessage());
            }
        }
    }

    @Test
    public void testValidUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty());
    }
}
