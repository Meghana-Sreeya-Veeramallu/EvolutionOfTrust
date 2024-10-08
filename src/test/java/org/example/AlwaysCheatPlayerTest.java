package org.example;

import org.example.Entities.AlwaysCheatPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCheatPlayerTest {

    @Test
    void testAlwaysCheatPlayerShouldStartWithZeroCoins() {
        AlwaysCheatPlayer player = new AlwaysCheatPlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for gain() method
    @Test
    void testPlayerShouldGainCorrectly() {
        AlwaysCheatPlayer player = new AlwaysCheatPlayer();
        player.gain();
        int expected = 3;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for invest() method
    @Test
    void testPlayerShouldInvestCorrectly() {
        AlwaysCheatPlayer player = new AlwaysCheatPlayer();
        player.invest();
        int expected = -1;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersCheat() {
        AlwaysCheatPlayer firstPlayer = new AlwaysCheatPlayer();
        AlwaysCheatPlayer secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }
}
