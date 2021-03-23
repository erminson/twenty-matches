package main.java.ru.erminson.twenty_matches;

import main.java.ru.erminson.twenty_matches.entity.Game;
import main.java.ru.erminson.twenty_matches.entity.Player;
import main.java.ru.erminson.twenty_matches.service.*;
import main.java.ru.erminson.twenty_matches.view.ConsoleView;
import main.java.ru.erminson.twenty_matches.view.IView;

public class MainConsole {
    public static void main(String[] args) {
        final Player player1 = new Player("AI", Player.PlayerType.AI);
        final Player player2 = new Player("Player2", Player.PlayerType.Human);
        final Player[] players = new Player[] { player1, player2 };

        final int[] possibleMatchesPerMove = new int[] {1, 2, 3};

        final Game game = new Game(players, possibleMatchesPerMove, 20, "20 Matches");

        final IAIService aiService = new AIService();

        final IView consoleView = new ConsoleView(aiService);

        final IFirstPlayerChoiceService firstPlayerChoiceService = new SimpleFirstPlayerChoiceService();

        final GameService gameService = new GameService(game, consoleView, firstPlayerChoiceService);

        gameService.start();
    }
}
