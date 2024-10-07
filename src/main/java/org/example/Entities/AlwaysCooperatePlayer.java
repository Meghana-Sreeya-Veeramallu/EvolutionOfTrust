package org.example.Entities;

import org.example.Enums.Move;
import org.example.Enums.PlayerType;

public class AlwaysCooperatePlayer extends Player {

    public AlwaysCooperatePlayer() {
        super(PlayerType.ALWAYS_COOPERATE);
    }

    @Override
    protected Move getMove() {
        return Move.COOPERATE;
    }
}
