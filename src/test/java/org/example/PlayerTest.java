package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerShouldStartWithZeroCoins() {
        Player player = new Player();
        int expected = 0;

        int actual = player.getCoins();

        assertEquals(expected, actual);
    }

    // Tests for add() method
    @Test
    void testPlayerShouldAddCorrectly() {
        Player player = new Player();
        player.add(2);
        int expected = 2;

        int actual = player.getCoins();

        assertEquals(expected, actual);
    }

    // Tests for deduct() method
    @Test
    void testPlayerShouldDeductCorrectly() {
        Player player = new Player();
        player.add(3);
        player.deduct(1);
        int expected = 2;

        int actual = player.getCoins();

        assertEquals(expected, actual);
    }

    @Test
    void testPlayerShouldHaveNegativeCoinsIfDeductedMoreThanAdded() {
        Player player = new Player();
        player.deduct(1);
        int expected = -1;

        int actual = player.getCoins();

        assertEquals(expected, actual);
    }
}
