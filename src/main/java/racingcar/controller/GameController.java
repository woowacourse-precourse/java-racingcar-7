package racingcar.controller;

import java.util.List;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
  private final GameService gameService;

  public GameController() {
    this.gameService = new GameService();
  }

  public void startGame() {
    OutputView.printCarNamePrompt();
    String carNames = InputView.getCarNames();

    OutputView.printGameCountPrompt();
    String gameCountInput = InputView.getTryCount();

    gameService.createGame(carNames, gameCountInput);

    OutputView.printGameStartMessage();
    while (!gameService.isGameOver()) {
      List<String> roundResults = gameService.playRound();
      OutputView.printCarPositions(roundResults);
    }

    List<String> winners = gameService.getWinners();
    OutputView.printWinners(winners);
  }
}
