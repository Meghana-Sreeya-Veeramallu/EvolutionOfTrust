package org.example.Entities;

import org.example.Exceptions.CannotHaveNegativeOrZeroRounds;
import org.example.Exceptions.CannotPlayWithoutPlayersException;

public class Game {
    private final Player firstPlayer;
    private final Player secondPlayer;;

    public Game(Player firstPlayer, Player secondPlayer) {
        if (firstPlayer == null || secondPlayer == null) {
            throw new CannotPlayWithoutPlayersException("Cannot play without players");
        }
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public void play(int rounds) {
        if (rounds <= 0) {
            throw new CannotHaveNegativeOrZeroRounds("Cannot have negative or zero rounds");
        }
        for (int i = 0; i < rounds; i++) {
            firstPlayer.playWith(secondPlayer);
        }
    }
}
