package pl.coderslab.seleniumcourse.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExample {
    @Test
    public void assertionsExample(){
        assertTrue(9>3);
        assertFalse(6<4);
        assertNotNull(new Object());

    }
}
