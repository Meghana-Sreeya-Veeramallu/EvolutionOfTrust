package org.example.Entities;

import org.example.Enums.Action;
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
        if (player1.getMove() == Action.COOPERATE  && player2.getMove() == Action.COOPERATE) {
            // Both cooperate: +2 each
            player1.addTwo();
            player2.addTwo();
        } else if (player1.getMove() == Action.COOPERATE) {
            // Player 1 cooperates, Player 2 cheats: Player 1: -1, Player 2: +3
            player1.deduct();
            player2.addThree();
        } else if (player2.getMove() == Action.COOPERATE) {
            // Player 1 cheats, Player 2 cooperates: : Player 1: +3, Player 2: -1
            player1.addThree();
            player2.deduct();
        }
        // Both cheat: Nothing happens
    }

    public void play(int rounds) {
        for (int i = 0; i < rounds; i++) {
            round();
        }
    }
}
