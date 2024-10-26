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
    String carNames = getCarNamesFromUser();
    String gameCountInput = getGameCountFromUser();

    gameService.createGame(carNames, gameCountInput);

    playAllRounds();
    printWinners();
  }

  private String getCarNamesFromUser() {
    OutputView.printCarNamePrompt();
    return InputView.getCarNames();
  }

  private String getGameCountFromUser() {
    OutputView.printGameCountPrompt();
    return InputView.getTryCount();
  }

  private void playAllRounds() {
    OutputView.printGameStartMessage();
    List<String> roundResults = gameService.playRound();
    while (!isLastRound(roundResults)) {
      OutputView.printCarPositions(roundResults);
      roundResults = gameService.playRound();
    }
  }

  private boolean isLastRound(List<String> roundResults) {
    return roundResults.isEmpty();
  }

  private void printWinners() {
    List<String> winners = gameService.getWinners();
    OutputView.printWinners(winners);
  }
}
