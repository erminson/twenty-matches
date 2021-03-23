package main.java.ru.erminson.twenty_matches.entity;

//import java.util.Arrays;

public class Game {
    private int matches;
    private final int[] possibleMatchesPerMove;
    private final Player[] players;
    private final String title;

    public Game(final Player[] players, int[] possibleMatchesPerMove, final int matches, final String title) {
        this.players = players;
        this.possibleMatchesPerMove = possibleMatchesPerMove;
        this.matches = matches;
        this.title = title;
    }

    public int getMatches() {
        return matches;
    }

    public int getPlayersNumber() {
        return this.players.length;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public int[] getPossibleMatchesPerMove() {
        return this.possibleMatchesPerMove;
    }

    public String getTitle() {
        return this.title;
    }
}
