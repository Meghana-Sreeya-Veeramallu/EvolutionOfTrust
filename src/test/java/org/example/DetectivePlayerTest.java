package org.example;

import org.example.Entities.DetectivePlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetectivePlayerTest {

    @Test
    void testDetectivePlayerShouldStartWithZeroCoins() {
        DetectivePlayer player = new DetectivePlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersDetectives() {
        DetectivePlayer firstPlayer = new DetectivePlayer();
        DetectivePlayer secondPlayer = new DetectivePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }
}