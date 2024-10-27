package racingcar.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.Model.Racing;
import racingcar.Utilities.Splitter;
import racingcar.Validation.CarValidator;
import racingcar.Validation.TurnCountValidator;
import racingcar.View.InputView;
import racingcar.View.OutputView;

public class RacingController {
  private Racing racing;

  public void startGame() {
    List<String> carsName = readCarsName();
    int turnCount = readTurnCount();
    startRacing(carsName, turnCount);
    printFinalWinner();
  }

  private List<String> readCarsName() {
    String carNames = InputView.readCarsName();
    List<String> splittedNames = Splitter.splitNames(carNames);
    CarValidator.validateCarNumber(splittedNames);
    CarValidator.validateDuplicateCarName(splittedNames);
    splittedNames.stream().forEach(CarValidator::validateCarName);
    return splittedNames;
  }

  private int readTurnCount() {
    String turnCount = InputView.readTurnCount();
    return TurnCountValidator.validateTurnCount(turnCount);
  }

  private void startRacing(List<String> carsName, int turnCount) {
    initializeRacing(carsName);
    IntStream.range(0, turnCount).forEach(i -> playRound());
  }

  private void initializeRacing(List<String> carsName) {
    this.racing = Racing.startRacing(carsName);
  }

  private void playRound() {
    racing.runRound();
    displayRoundResult();
  }

  private void displayRoundResult() {
    OutputView.printResultOfTurn(racing.resultOfRound());
  }

  private void printFinalWinner() {
    ArrayList<String> winner = racing.pickWinner();
    OutputView.printWinner(winner);
  }
}
