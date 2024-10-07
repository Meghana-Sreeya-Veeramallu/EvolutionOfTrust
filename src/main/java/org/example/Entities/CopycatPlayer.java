package org.example.Entities;

import org.example.Enums.Move;
import org.example.Enums.PlayerType;

public class CopycatPlayer extends Player {
    private Move lastOpponentMove;

    public CopycatPlayer() {
        super(PlayerType.COPYCAT);
        this.lastOpponentMove = Move.CHEAT;
    }

    @Override
    public void playWith(Player otherPlayer) {
        Move copycatMove = this.getMove();
        Move opponentMove = otherPlayer.getMove();

        if (copycatMove == Move.COOPERATE) {
            this.invest();
            otherPlayer.gain();
        }
        if (opponentMove == Move.COOPERATE) {
            this.gain();
            otherPlayer.invest();
        }

        this.lastOpponentMove = opponentMove;
    }

    @Override
    protected Move getMove() {
        return this.lastOpponentMove;
    }
}

