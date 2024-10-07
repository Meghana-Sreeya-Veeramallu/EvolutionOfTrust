package org.example;

import org.example.Entities.AlwaysCheatPlayer;
import org.example.Entities.AlwaysCooperatePlayer;
import org.example.Entities.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCooperatePlayerTest {

    @Test
    void testPlayerAlwaysCooperateShouldStartWithZeroCoins() {
        Player player = new AlwaysCooperatePlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersCooperate() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCooperatesSecondPlayerCheats() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCheatsSecondPlayerCooperates() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }
}
