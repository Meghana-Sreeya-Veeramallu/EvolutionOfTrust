package org.example;

import java.util.Random;

public class Game {
    private final Player player1;
    private final Player player2;;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void round(boolean p1Cooperates, boolean p2Cooperates) {
        if (p1Cooperates && p2Cooperates) {
            // Both cooperate: 2 coins each
            player1.add(2);
            player2.add(2);
        } else if (p1Cooperates) {
            // Player 1 cooperates, Player 2 cheats: Player 1 loses 1 coin, Player 2 gains 3 coins
            player1.deduct(1);
            player2.add(3);
        } else if (p2Cooperates) {
            // Player 1 cheats, Player 2 cooperates: : Player 1 gains 3 coins, Player 2 loses 1 coin
            player1.add(3);
            player2.deduct(1);
        }
        // Both cheat: Nothing happens
    }

    public void play(int rounds) {
        Random random = new Random();
        for (int i = 0; i < rounds; i++) {
            round(random.nextBoolean(), random.nextBoolean());
        }
    }
}
