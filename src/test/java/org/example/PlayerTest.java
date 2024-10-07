package org.example;

import org.example.Entities.Player;
import org.example.Enums.Action;
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

    // Tests for add() method
    @Test
    void testPlayerShouldAddCorrectly() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        player.addTwo();
        int expected = 2;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for deduct() method
    @Test
    void testPlayerShouldDeductCorrectly() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        player.addThree();
        player.deduct();
        int expected = 2;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    @Test
    void testPlayerShouldHaveNegativeCoinsIfDeductedMoreThanAdded() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        player.deduct();
        int expected = -1;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for getMove() method
    @Test
    public void testGetMoveForAlwaysCooperative() {
        Player player = new Player(PlayerType.ALWAYS_COOPERATE);
        assertEquals(Action.COOPERATE, player.getMove());
    }

    @Test
    public void testGetMoveForAlwaysCheat() {
        Player player = new Player(PlayerType.ALWAYS_CHEAT);
        assertEquals(Action.CHEAT, player.getMove());
    }
}
