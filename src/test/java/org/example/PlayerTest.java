package org.example;

import org.example.Entities.Game;
import org.example.Entities.Player;
import org.example.Enums.PlayerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerAlwaysCheatShouldStartWithZeroCoins() {
        Player player = new Player(PlayerType.ALWAYS_CHEAT);
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    @Test
    void testPlayerAlwaysCooperateShouldStartWithZeroCoins() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for round() method
    @Test
    void testBothPlayersCooperate() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);

        firstPlayer.playWith(secondPlayer);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCooperatesSecondPlayerCheats() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCheatsSecondPlayerCooperates() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersCheat() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

}
