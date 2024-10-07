package org.example.Entities;

import org.example.Enums.Action;
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

    public void addTwo() {
        this.score += 2;
    }

    public void addThree() {
        this.score += 3;
    }

    public void deduct() {
        this.score -= 1;
    }
    public Action getMove() {
        if (this.playerType == PlayerType.ALWAYS_COOPERATE) {
            return Action.COOPERATE;
        }
        else{
            return Action.CHEAT;
        }
    }
}
