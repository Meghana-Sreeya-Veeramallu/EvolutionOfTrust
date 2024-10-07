package org.example.Entities;

import org.example.Enums.Move;
import org.example.Enums.PlayerType;

public abstract class Player {
    private int score;

    public Player(PlayerType playerType) {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void playWith(Player otherPlayer) {
        if (this.getMove() == Move.COOPERATE) {
            // Player 1 cooperates - Player 1: -1, Player 2: +3
            this.invest();
            otherPlayer.gain();
        }
        if (otherPlayer.getMove() == Move.COOPERATE) {
            // Player 2 cooperates - Player 1: +3, Player 2: -1
            this.gain();
            otherPlayer.invest();
        }
    }

    protected abstract Move getMove();

    public void gain() {
        this.score += 3;
    }

    public void invest() {
        this.score -= 1;
    }
}
