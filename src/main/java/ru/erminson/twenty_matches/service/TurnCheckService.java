package main.java.ru.erminson.twenty_matches.service;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TurnCheckService {
    private int[] possibleMatchesPerMove;

    public TurnCheckService(int[] possibleMatchesPerMove) {
        this.possibleMatchesPerMove = possibleMatchesPerMove;
    }

    public int[] getPossibleMatchesPerMove(final int matchesOnBoard) {
        return IntStream.of(this.possibleMatchesPerMove).filter(v -> matchesOnBoard - v >= 1).toArray();
    }

    public boolean isValid(final int matches, final int matchesOnBoard) {
        return IntStream.of(this.possibleMatchesPerMove).anyMatch(v -> v == matches) && matchesOnBoard - matches >= 1;
    }
}
