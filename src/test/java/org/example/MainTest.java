package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void isEven() {
        assertTrue(Main.isEven(0));
        assertTrue(Main.isEven(2));
        assertTrue(Main.isEven(-4));
        assertTrue(Main.isEven(203478542));
        assertFalse(Main.isEven(1));
        assertFalse(Main.isEven(-1));
        assertFalse(Main.isEven(5));
        assertFalse(Main.isEven(543434341));
    }
}