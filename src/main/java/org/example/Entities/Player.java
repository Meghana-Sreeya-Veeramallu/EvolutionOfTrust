package org.example.Entities;

import org.example.Enums.Move;
import org.example.Enums.PlayerType;

public class Player {
    private int score;
    private final PlayerType playerType;

    public Player(PlayerType playerType) {
        this.score = 0;
        this.playerType = playerType;
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
            // Player 2 cooperates - : Player 1: +3, Player 2: -1
            this.gain();
            otherPlayer.invest();
        }
        // Both cooperate: +2 each ( -1 + 3 = +2)
        // Both cheat: Nothing happens
    }

    private void gain() {
        this.score += 3;
    }

    private void invest() {
        this.score -= 1;
    }

    private Move getMove() {
        if (this.playerType == PlayerType.ALWAYS_COOPERATE) {
            return Move.COOPERATE;
        }
        else{
            return Move.CHEAT;
        }
    }
}
