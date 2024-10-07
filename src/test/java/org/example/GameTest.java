package org.example;

import org.example.Entities.Game;
import org.example.Entities.Player;
import org.example.Enums.PlayerType;
import org.example.Exceptions.CannotPlayWithoutPlayersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    // Tests for Game class
    @Test
    void testGameInitialization() {
        Player player1 = new Player(PlayerType.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(player1, player2);

        assertNotNull(game);
    }

    @Test
    void testExceptionWhenPlayerIsNull() {
        assertThrows(CannotPlayWithoutPlayersException.class, () -> new Game(null, null));
    }

    // Tests for round() method
    @Test
    void testBothPlayersCooperate() {
        Player player1 = new Player(PlayerType.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(player1, player2);

        game.round();

        assertEquals(2, player1.getScore());
        assertEquals(2, player2.getScore());
    }

    @Test
     void testPlayer1CooperatesPlayer2Cheats() {
        Player player1 = new Player(PlayerType.ALWAYS_COOPERATE);
        Player player2 = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(player1, player2);

        game.round();

        assertEquals(-1, player1.getScore());
        assertEquals(3, player2.getScore());
    }

    @Test
     void testPlayer1CheatsPlayer2Cooperates() {
        Player player1 = new Player(PlayerType.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(player1, player2);

        game.round();

        assertEquals(3, player1.getScore());
        assertEquals(-1, player2.getScore());
    }

    @Test
     void testBothPlayersCheat() {
        Player player1 = new Player(PlayerType.ALWAYS_CHEAT);
        Player player2 = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(player1, player2);

        game.round();

        assertEquals(0, player1.getScore());
        assertEquals(0, player2.getScore());
    }
}
