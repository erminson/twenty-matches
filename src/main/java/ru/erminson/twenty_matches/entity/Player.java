package main.java.ru.erminson.twenty_matches.entity;

public class Player {
    public enum PlayerType {
        Human, AI
    }

    String name;
    PlayerType playerType;

    public Player(String name, PlayerType playerType) {
        this.name = name;
        this.playerType = playerType;
    }

    public String getName() {
        return this.name;
    }

    public PlayerType getPlayerType() {
        return this.playerType;
    }
}
