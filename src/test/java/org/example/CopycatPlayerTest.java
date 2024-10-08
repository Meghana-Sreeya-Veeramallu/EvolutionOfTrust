package org.example;

import org.example.Entities.CopycatPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopycatPlayerTest {

    @Test
    void testCopycatPlayerShouldStartWithZeroCoins() {
        CopycatPlayer player = new CopycatPlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for gain() method
    @Test
    void testPlayerShouldGainCorrectly() {
        CopycatPlayer player = new CopycatPlayer();
        player.gain();
        int expected = 3;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for invest() method
    @Test
    void testPlayerShouldInvestCorrectly() {
        CopycatPlayer player = new CopycatPlayer();
        player.invest();
        int expected = -1;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersCopycats() {
        CopycatPlayer firstPlayer = new CopycatPlayer();
        CopycatPlayer secondPlayer = new CopycatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

}