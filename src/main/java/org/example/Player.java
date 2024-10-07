package org.example;

public class Player {
    private int coins;

    public Player() {
        this.coins = 0;
    }

    public int getCoins() {
        return coins;
    }

    public void add(int coins) {
        this.coins += coins;
    }

    public void deduct(int coins) {
        this.coins -= coins;
    }
}
