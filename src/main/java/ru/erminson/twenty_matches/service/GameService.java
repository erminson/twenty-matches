package main.java.ru.erminson.twenty_matches.service;

import main.java.ru.erminson.twenty_matches.entity.Game;
import main.java.ru.erminson.twenty_matches.entity.Player;
import main.java.ru.erminson.twenty_matches.view.IView;

public class GameService {
    private final Game game;
    private final IView view;

    private int matchesOnBoard;
    private int currentIndexPlayer;
    private TurnCheckService turnCheckService;

    public GameService(final Game game, final IView view, final IFirstPlayerChoiceService firstPlayerChoiceService) {
        this.game = game;
        this.view = view;

        this.matchesOnBoard = game.getMatches();
        this.currentIndexPlayer = firstPlayerChoiceService.getFirstPlayer(game.getPlayersNumber());

        this.turnCheckService = new TurnCheckService(game.getPossibleMatchesPerMove());
    }

    public void start() {
        this.view.startGame(game);
        while(true) {
            final Player player = game.getPlayers()[this.currentIndexPlayer];
            this.view.showMatchesOnBoard(matchesOnBoard);
            int matches = this.view.makeTurn(player, this.turnCheckService, matchesOnBoard);
            matchesOnBoard -= matches;
            if (isGameOver()) {
                break;
            } else {
                this.currentIndexPlayer = getNextPlayerIndex(currentIndexPlayer, game.getPlayersNumber());
            }
        }
        final Player winner = game.getPlayers()[this.currentIndexPlayer];
        this.view.showWinner(winner.getName());
    }

    private boolean isGameOver() {
        return matchesOnBoard == 1;
    }

    private int getNextPlayerIndex(final int currentIndex, final int playersNumber) {
        if (currentIndex + 1 == playersNumber) {
            return 0;
        }

        return currentIndex + 1;
    }
}
