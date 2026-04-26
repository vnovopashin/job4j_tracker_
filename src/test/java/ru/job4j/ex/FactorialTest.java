package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void whenInputNumberIsLessThanZero() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Factorial().calc(-1));
        assertEquals("Number could not be less than 0", exception.getMessage());
    }
}
