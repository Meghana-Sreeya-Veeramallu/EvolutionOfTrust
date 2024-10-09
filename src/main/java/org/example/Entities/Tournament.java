package org.example.Entities;

import org.example.Exceptions.CannotHaveLessThanTenPlayersException;
import org.example.Exceptions.CannotHaveNegativeOrZeroRounds;
import org.example.Exceptions.CannotHaveNegativePlayersException;

import java.util.*;

public class Tournament {
    Map<Player, Integer> players;

    public Tournament(int numberOfAlwaysCheatPlayers, int numberOfAlwaysCooperatePlayers, int numberOfCopycatPlayers) {
        if (numberOfAlwaysCheatPlayers<=0 || numberOfAlwaysCooperatePlayers<=0 || numberOfCopycatPlayers<=0) {
            throw new CannotHaveNegativePlayersException("Cannot have negative number of players");
        }
        if (numberOfAlwaysCheatPlayers + numberOfAlwaysCooperatePlayers + numberOfCopycatPlayers < 10){
            throw new CannotHaveLessThanTenPlayersException("Cannot have less than 10 players");
        }
        players = new LinkedHashMap<>();

        for (int i = 0; i < numberOfAlwaysCheatPlayers; i++) {
            players.put(new AlwaysCheatPlayer(), 0);
        }

        for (int i = 0; i < numberOfAlwaysCooperatePlayers; i++) {
            players.put(new AlwaysCooperatePlayer(), 0);
        }

        for (int i = 0; i < numberOfCopycatPlayers; i++) {
            players.put(new CopycatPlayer(), 0);
        }
    }

    public void playTournament(int rounds) throws CloneNotSupportedException {
        if (rounds <= 0) {
            throw new CannotHaveNegativeOrZeroRounds("Cannot have negative or zero rounds");
        }
        while (!areAllPlayersSameType()) {;
            playGames(rounds);
            displayScores();
            eliminateAndPromotePlayers();
        }
        System.out.println("\nAll players left are of : " + players.keySet().iterator().next().getClass().getSimpleName());
    }

    private boolean areAllPlayersSameType() {
        if (players.size() <= 1) return true;

        Iterator<Player> iterator = players.keySet().iterator();
        Class<?> firstPlayerClass = iterator.next().getClass();

        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (!player.getClass().equals(firstPlayerClass)) {
                return false;
            }
        }
        return true;
    }

    private void playGames(int rounds) throws CloneNotSupportedException {
        List<Player> playerList = new ArrayList<>(players.keySet());
        int playerCount = playerList.size();
        for (int i = 0; i < playerCount; i++) {
            for (int j = i + 1; j < playerCount; j++) {
                Player playerA = (Player) playerList.get(i).clone();
                Player playerB = (Player) playerList.get(j).clone();

                Game game = new Game(playerA, playerB);
                game.play(rounds);

                players.put(playerList.get(i), players.get(playerList.get(i)) + playerA.getScore());
                players.put(playerList.get(j), players.get(playerList.get(j)) + playerB.getScore());
            }
        }
    }

    private void displayScores(){
        System.out.println("\nNew Iteration\n");
        for (Map.Entry<Player, Integer> entry : players.entrySet()) {
            System.out.println(entry.getKey().getClass().getSimpleName() + " Score: " + entry.getValue());
        }
    }

    private void eliminateAndPromotePlayers() throws CloneNotSupportedException {
        List<Map.Entry<Player, Integer>> playerList = new ArrayList<>(players.entrySet());
        int totalPlayers = playerList.size();

        // Sort using value in descending order
        playerList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Eliminate bottom 5
        for (int i = totalPlayers - 1; i >= totalPlayers - 5; i--) {
            players.remove(playerList.get(i).getKey());
        }

        // Promote top 5
        List<Map.Entry<Player, Integer>> topFive = playerList.subList(0, 5);
        for (Map.Entry<Player, Integer> entry : topFive) {
            players.put((Player) entry.getKey().clone(), 0);
        }

        // Reset score
        players.replaceAll((p, v) -> 0);

        // Sort the players map using the player class
        Map<Player, Integer> sortedPlayers = new LinkedHashMap<>();

        players.keySet().stream()
                .sorted(Comparator.comparing(player -> player.getClass().getSimpleName()))
                .forEach(key -> sortedPlayers.put(key, players.get(key)));

        players = sortedPlayers;
    }
}
