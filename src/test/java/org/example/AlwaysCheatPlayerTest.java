package org.example;

import org.example.Entities.AlwaysCheatPlayer;
import org.example.Entities.AlwaysCooperatePlayer;
import org.example.Entities.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCheatPlayerTest {

    @Test
    void testPlayerAlwaysCheatShouldStartWithZeroCoins() {
        Player player = new AlwaysCheatPlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersCheat() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCheatsSecondPlayerCooperates() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCooperatesSecondPlayerCheats() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }
}
