package org.example;

import org.example.Entities.Tournament;
import org.example.Exceptions.CannotHaveLessThanTenPlayersException;
import org.example.Exceptions.CannotHaveNegativeOrZeroRounds;
import org.example.Exceptions.CannotHaveNegativePlayersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentTest {
    // Tests for Tournament class
    @Test
    void testNegativeAlwaysCheatPlayers() {
        assertThrows(CannotHaveNegativePlayersException.class, () -> {
            new Tournament(-1, 5, 5);
        });
    }

    @Test
    void testNegativeAlwaysCooperatePlayers() {
        assertThrows(CannotHaveNegativePlayersException.class, () -> {
            new Tournament(10, -1, 10);
        });
    }

    @Test
    void testNegativeCopycatPlayers() {
        assertThrows(CannotHaveNegativePlayersException.class, () -> {
            new Tournament(10, 5, -1);
        });
    }

    @Test
    public void testTournamentConstructor() {
        assertDoesNotThrow(() -> {
            new Tournament(10, 10, 10);
        });
    }

    @Test
    void testLessThanTenPlayers() {
        assertThrows(CannotHaveLessThanTenPlayersException.class, () -> {
            new Tournament(4, 4, 1);
        });
    }

    @Test
    void testExactTenPlayers() {
        assertDoesNotThrow(() -> {
            new Tournament(5, 4, 1);
        });
    }

    @Test
    void testMoreThanTenPlayers() {
        assertDoesNotThrow(() -> {
            new Tournament(5, 4, 2);
        });
    }

    // Tests for playTournament() method
    @Test
    void testNegativeRounds() {
        Tournament tournament = new Tournament(5, 5, 5);
        assertThrows(CannotHaveNegativeOrZeroRounds.class, () -> {
            tournament.playTournament(-1);
        });
    }

    @Test
    void testZeroRounds() {
        Tournament tournament = new Tournament(5, 5, 5);
        assertThrows(CannotHaveNegativeOrZeroRounds.class, () -> {
            tournament.playTournament(0);
        });
    }

    @Test
    void testPositiveRounds() {
        Tournament tournament = new Tournament(5, 5, 5);
        assertDoesNotThrow(() -> {
            tournament.playTournament(1);
        });
    }

    @Test
    public void testPlayTournamentWithTenAllPlayers() throws CloneNotSupportedException {
        Tournament tournament = new Tournament(10, 10, 10);
        tournament.playTournament(1);
    }

    @Test
    public void testPlayTournamentWithOneTenTenPlayers() throws CloneNotSupportedException {
        Tournament tournament = new Tournament(1, 10, 10);
        tournament.playTournament(5);
    }

    @Test
    public void testPlayTournamentWithTenOneTenPlayers() throws CloneNotSupportedException {
        Tournament tournament = new Tournament(10, 1, 10);
        tournament.playTournament(10);
    }

    @Test
    public void testPlayTournamentWithTenTenOnePlayers() throws CloneNotSupportedException {
        Tournament tournament = new Tournament(10, 10, 1);
        tournament.playTournament(2);
    }
}
