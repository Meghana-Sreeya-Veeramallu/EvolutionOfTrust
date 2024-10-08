package org.example;

import org.example.Entities.AlwaysCooperatePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCooperatePlayerTest {

    @Test
    void testAlwaysCooperatePlayerShouldStartWithZeroCoins() {
        AlwaysCooperatePlayer player = new AlwaysCooperatePlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for gain() method
    @Test
    void testPlayerShouldGainCorrectly() {
        AlwaysCooperatePlayer player = new AlwaysCooperatePlayer();
        player.gain();
        int expected = 3;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for invest() method
    @Test
    void testPlayerShouldInvestCorrectly() {
        AlwaysCooperatePlayer player = new AlwaysCooperatePlayer();
        player.invest();
        int expected = -1;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersCooperate() {
        AlwaysCooperatePlayer firstPlayer = new AlwaysCooperatePlayer();
        AlwaysCooperatePlayer secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }
}
