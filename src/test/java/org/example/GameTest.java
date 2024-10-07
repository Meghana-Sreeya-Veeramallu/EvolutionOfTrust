package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    // Tests for round() method
    @Test
    void testBothCooperate() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game(player1, player2);

        game.round(true, true);

        assertEquals(2, player1.getCoins());
        assertEquals(2, player2.getCoins());
    }

    @Test
    void testPlayer1CooperatesPlayer2Cheats() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game(player1, player2);

        game.round(true, false);

        assertEquals(-1, player1.getCoins());
        assertEquals(3, player2.getCoins());
    }

    @Test
    void testPlayer1CheatsPlayer2Cooperates() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game(player1, player2);

        game.round(false, true);

        assertEquals(3, player1.getCoins());
        assertEquals(-1, player2.getCoins());
    }

    @Test
     void testBothCheat() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game(player1, player2);

        game.round(false, false);

        assertEquals(0, player1.getCoins());
        assertEquals(0, player2.getCoins());
    }

    @Test
     void testPlayWithMultipleRounds() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game(player1, player2);

        game.round(true, true);  // Round 1: Both cooperate
        game.round(true, false); // Round 2: Player 1 cooperates, Player 2 cheats
        game.round(false, true); // Round 3: Player 1 cheats, Player 2 cooperates
        game.round(false, false); // Round 4: Both cheat

        assertEquals(4, player1.getCoins());
        assertEquals(4, player2.getCoins());
    }

    @Test
     void testPlayMultipleRounds() {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game(player1, player2);

        game.play(5);

        assertTrue(player1.getCoins() >= 0);
        assertTrue(player2.getCoins() >= 0);
    }
}
