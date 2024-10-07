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
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(firstPlayer, secondPlayer);

        assertNotNull(game);
    }

    @Test
    void testExceptionWhenPlayerIsNull() {
        assertThrows(CannotPlayWithoutPlayersException.class, () -> new Game(null, null));
    }

    // Tests for round() method
    @Test
    void testBothPlayersCooperate() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(firstPlayer, secondPlayer);

        game.play(1);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
     void testFirstPlayerCooperatesSecondPlayerCheats() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(firstPlayer, secondPlayer);

        game.play(1);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
     void testFirstPlayerCheatsSecondPlayerCooperates() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(firstPlayer, secondPlayer);

        game.play(1);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
     void testBothPlayersCheat() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(firstPlayer, secondPlayer);

        game.play(1);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersCheatFiveRounds() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(firstPlayer, secondPlayer);

        game.play(5);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersCooperateFiveRounds() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Game game = new Game(firstPlayer, secondPlayer);

        game.play(5);

        assertEquals(10, firstPlayer.getScore());
        assertEquals(10, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCooperatesSecondPlayerCheatsFiveRounds() {
        Player firstPlayer = new Player(PlayerType.ALWAYS_COOPERATE);
        Player secondPlayer = new Player(PlayerType.ALWAYS_CHEAT);
        Game game = new Game(firstPlayer, secondPlayer);

        game.play(5);

        assertEquals(-5, firstPlayer.getScore());
        assertEquals(15, secondPlayer.getScore());
    }
}
