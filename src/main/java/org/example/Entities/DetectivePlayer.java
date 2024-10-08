package org.example.Entities;

import org.example.Enums.Move;

public class DetectivePlayer extends Player {
    private int moveNumber = 1;
    private boolean hasCheatedBack  = false;
    private Move lastOpponentMove;

    public DetectivePlayer() {
        super();
    }

    @Override
    public void playWith(Player otherPlayer) {
        Move playerMove = this.nextMove();
        Move opponentMove = otherPlayer.nextMove();

        super.updateScore(playerMove, opponentMove, otherPlayer);

        this.lastOpponentMove = opponentMove;
    }

    @Override
    protected void gain(){
        this.lastOpponentMove = Move.COOPERATE;
        super.gain();
    }

    @Override
    protected Move nextMove() {
        int currentMoveNumber = this.moveNumber;
        Move currentMove = this.lastOpponentMove;

        if (this.lastOpponentMove == Move.CHEAT) {
            hasCheatedBack = true;
        }

        this.moveNumber++;
        this.lastOpponentMove = Move.CHEAT;

        return switch (currentMoveNumber) {
            case 1, 3, 4 -> Move.COOPERATE;
            case 2 -> Move.CHEAT;
            default -> hasCheatedBack ? currentMove : Move.CHEAT;
        };
    }
}
