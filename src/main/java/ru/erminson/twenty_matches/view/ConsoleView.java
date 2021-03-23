package main.java.ru.erminson.twenty_matches.view;

import main.java.ru.erminson.twenty_matches.entity.Game;
import main.java.ru.erminson.twenty_matches.entity.Player;
import main.java.ru.erminson.twenty_matches.service.IAIService;
import main.java.ru.erminson.twenty_matches.service.TurnCheckService;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView implements IView {
    private IAIService aiService;

    public ConsoleView(final IAIService aiService) {
        this.aiService = aiService;
    }

    @Override
    public void startGame(final Game game) {
        System.out.println("Start game \"" + game.getTitle() + "\"");
    }

    @Override
    public void showWinner(String name) {
        System.out.println("Player " + name + " is win!");
    }

    @Override
    public int makeTurn(final Player player, final TurnCheckService turnCheckService, final int matchesOnBoard) {
        System.out.println("Player turn: " + player.getName());
        int matches;
        switch (player.getPlayerType()) {
            case Human:
                matches = inputMatchesFromConsole(turnCheckService, matchesOnBoard);
                break;
            case AI:
                matches = this.aiService.aiMakeTurn(matchesOnBoard);
                break;
            default:
                matches = 0;
        }

        System.out.println("Player " + player.getName() + " get " + matches + " matches");
        System.out.println("---------------");
        return matches;
    }

    @Override
    public void showMatchesOnBoard(final int matches) {
        System.out.println("On board " + matches + " matches");
    }

    private int inputMatchesFromConsole(final TurnCheckService turnCheckService, final int matchesOnBoard) {
        while (true) {
            System.out.println(
                    "Enter count of matches ("
                            + getMatches(turnCheckService.getPossibleMatchesPerMove(matchesOnBoard))
                            + "): ");
            try {
                final Scanner in = new Scanner(System.in);
                int inputMatches = in.nextInt();
                if (turnCheckService.isValid(inputMatches, matchesOnBoard)) {
                    return inputMatches;
                } else {
                    System.out.println("Not correct value");
                }
            } catch (final InputMismatchException e) {
                System.out.println("Not correct value");
            }
        }
    }

    private String getMatches(int[] matches) {
        return Arrays.toString(matches)
                .replace("[", "")
                .replace("]", "");
    }
}
