package org.example.Entities;

import org.example.Enums.Move;

public abstract class Player implements Cloneable {
    private int score;

    public Player() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    protected void updateScore(Move playerMove, Move opponentMove, Player otherPlayer) {
        if (playerMove == Move.COOPERATE) {
            // Player 1 cooperates - Player 1: -1, Player 2: +3
            this.invest();
            otherPlayer.gain();
        }
        if (opponentMove == Move.COOPERATE) {
            // Player 2 cooperates - Player 1: +3, Player 2: -1
            this.gain();
            otherPlayer.invest();
        }
    }

    public void playWith(Player otherPlayer) {
        Move playerMove = this.nextMove();
        Move opponentMove = otherPlayer.nextMove();
        this.updateScore(playerMove, opponentMove, otherPlayer);
    }

    protected abstract Move nextMove();

    protected void gain() {
        this.score += 3;
    }

    private void invest() {
        this.score -= 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
