package racingcar.controller;

import racingcar.factory.GameFactory;
import racingcar.model.Game;
import racingcar.model.Player;
import racingcar.validate.Validator;
import racingcar.view.PrintHelper;
import racingcar.view.ReaderHelper;

import java.util.List;

public class GameController {

    private final ReaderHelper readerHelper;
    private final PrintHelper printHelper;
    private final Validator validator;
    private final GameFactory gameFactory;

    public GameController(ReaderHelper readerHelper, PrintHelper printHelper,
                          Validator validator, GameFactory gameFactory) {
        this.readerHelper = readerHelper;
        this.printHelper = printHelper;
        this.validator = validator;
        this.gameFactory = gameFactory;
    }

    public void run() {
        Game game = initGame();
        progress(game);
        endGame(game);
    }

    private Game initGame() {
        Game game = gameFactory.getGame();
        addPlayers(game);
        return game;
    }

    private void addPlayers(Game game) {
        List<String> playerNames = readerHelper.readPlayerName();

        for (String playerName : playerNames) {
            validator.validateName(playerName);
            Player player = gameFactory.getPlayer(playerName);
            game.addPlayer(player);
        }
    }

    private void progress(Game game) {

        int time = readerHelper.readPlayTime(validator);

        List<Player> players = game.getPlayers();

        printHelper.startScoreBoard();

        for (int t = 0; t < time; t++) {
            game.progress();
            printHelper.printScoreBoard(players);
        }
    }

    private void endGame(Game game) {
        List<Player> winner = game.getWinner();
        printHelper.printResult(winner);
    }
}
