package main.java.ru.erminson.twenty_matches.view;

import main.java.ru.erminson.twenty_matches.entity.Game;
import main.java.ru.erminson.twenty_matches.entity.Player;
import main.java.ru.erminson.twenty_matches.service.TurnCheckService;

public interface IView {
    void startGame(final Game game);
    void showMatchesOnBoard(final int matches);
    int makeTurn(final Player player, final TurnCheckService turnCheckService, final int matchesOnBoard);

    void showWinner(final String name);
}
