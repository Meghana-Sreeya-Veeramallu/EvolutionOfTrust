package org.example;

import org.example.Entities.AlwaysCheatPlayer;
import org.example.Entities.AlwaysCooperatePlayer;
import org.example.Entities.CopycatPlayer;
import org.example.Entities.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    // Tests for playWith() method for AlwaysCheatPlayer with others
    @Test
    void testFirstPlayerAlwaysCheatsSecondPlayerAlwaysCooperates() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCheatsSecondPlayerCopycat() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new CopycatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    // Tests for playWith() method for AlwaysCooperatePlayer with others
    @Test
    void testFirstPlayerAlwaysCooperatesSecondPlayerAlwaysCheats() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCooperatesSecondPlayerCopycat() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new CopycatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    // Tests for playWith() method for CopycatPlayer with others
    @Test
    void testFirstPlayerCopycatSecondPlayerAlwaysCheats() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCopycatSecondPlayerAlwaysCooperates() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }
}
