package org.example.Entities;

import org.example.Enums.Move;
import org.example.Exceptions.CannotPlayWithoutPlayersException;

public class Game {
    private final Player player1;
    private final Player player2;;

    public Game(Player player1, Player player2) {
        if (player1 == null || player2 == null) {
            throw new CannotPlayWithoutPlayersException("Cannot play without players");
        }
        this.player1 = player1;
        this.player2 = player2;
    }

    private void round() {
         if (player1.getMove() == Move.COOPERATE) {
            // Player 1 cooperates - Player 1: -1, Player 2: +3
            player1.invest();
            player2.gain();
        }
         if (player2.getMove() == Move.COOPERATE) {
            // Player 2 cooperates - : Player 1: +3, Player 2: -1
            player1.gain();
            player2.invest();
        }
         // Both cooperate: +2 each ( -1 + 3 = +2)
         // Both cheat: Nothing happens
    }

    public void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            round();
        }
    }
}
