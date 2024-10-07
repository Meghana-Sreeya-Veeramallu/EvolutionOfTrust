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

    public void gain() {
        this.score += 3;
    }

    public void invest() {
        this.score -= 1;
    }

    public Move getMove() {
        if (this.playerType == PlayerType.ALWAYS_COOPERATE) {
            return Move.COOPERATE;
        }
        else{
            return Move.CHEAT;
        }
    }
}
