package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

  private final InputView inputView;
  private final OutputView outputView;
  private final GameService gameService;

  public GameController() {
    this.inputView = new InputView();
    this.outputView = new OutputView();
    this.gameService = new GameService();
  }

  public void startGame() {
    String carNamesInput = collectInputCarNames();
    String gameCountInput = collectInputGameCount();

    initializeGame(carNamesInput, gameCountInput);
    this.outputView.printGameStartMessage();

    runGameLoop();

    displayResults();
  }

  private String collectInputCarNames() {
    return this.inputView.getCarNames();
  }

  private String collectInputGameCount() {
    return this.inputView.getGameCount();
  }

  private void initializeGame(String carNamesInput, String gameCountInput) {
    this.gameService.initializeGame(carNamesInput, gameCountInput);
  }

  private void runGameLoop() {
    while (this.gameService.canPlay()) {
      this.gameService.playRound();
      this.outputView.printCarPositions(this.gameService.getCurrentStatuses());
    }
  }

  private void displayResults() {
    this.outputView.printWinners(this.gameService.getWinners());
  }
}
