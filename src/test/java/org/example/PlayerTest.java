package org.example;

import org.example.Entities.Player;
import org.example.Enums.Move;
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

    // Tests for gain() method
    @Test
    void testPlayerShouldGainCorrectly() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        player.gain();
        int expected = 3;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for invest() method
    @Test
    void testPlayerShouldInvestCorrectly() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        player.invest();
        int expected = -1;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    @Test
    void testPlayerInvestAfterGain() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        player.gain();
        player.invest();
        int expected = 2;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for getMove() method
    @Test
    public void testGetMoveForAlwaysCooperative() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        assertEquals(Move.COOPERATE, player.getMove());
    }

    @Test
    public void testGetMoveForAlwaysCheat() {
        Player player = new Player(PlayerType.ALWAYS_CHEAT);
        assertEquals(Move.CHEAT, player.getMove());
    }
}
