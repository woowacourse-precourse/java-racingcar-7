package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Racing;
import racingcar.utilities.Splitter;
import racingcar.validation.CarValidator;
import racingcar.validation.TurnCountValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
  private Racing racing;

  public void startGame() {
    List<String> carsName = readCarsName();
    int turnCount = readTurnCount();
    printGameResultMessage();
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

  private void printGameResultMessage() {
    OutputView.printGameResultMessage();
  }
}
