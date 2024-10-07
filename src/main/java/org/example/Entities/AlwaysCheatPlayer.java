package org.example.Entities;

import org.example.Enums.Move;
import org.example.Enums.PlayerType;

public class AlwaysCheatPlayer extends Player {

    public AlwaysCheatPlayer() {
        super(PlayerType.ALWAYS_CHEAT);
    }

    @Override
    protected Move getMove() {
        return Move.CHEAT;
    }
}

