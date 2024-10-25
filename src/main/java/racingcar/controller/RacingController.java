package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarFactory;
import racingcar.model.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

  private final CarFactory carFactory;
  private final InputView inputView;
  private final OutputView outputView;

  public RacingController() {
    this.carFactory = new CarFactory();
    this.inputView = new InputView();
    this.outputView = new OutputView();
  }

  public void run() {
    List<Car> cars = getCars();
    RacingCarGame racingCarGame = new RacingCarGame(cars);
    playGame(racingCarGame, inputView.inputTryCount());
    outputView.printLastWinner(racingCarGame.getWinners());
  }

  private List<Car> getCars() {
    String carNames = inputView.inputCarNames();
    return carFactory.extractCarNames(carNames);
  }

  private void playGame(RacingCarGame racingCarGame, int tryCount) {
    outputView.printResult();
    racingCarGame.isReady(tryCount);
    for (int i = 0; i < tryCount; i++) {
      racingCarGame.play();
      racingCarGame.cars()
              .forEach(car -> outputView.printCarAndMoveCount(car.getCarName(), car.getMoveCount()));
      System.out.println();
    }
  }
}
