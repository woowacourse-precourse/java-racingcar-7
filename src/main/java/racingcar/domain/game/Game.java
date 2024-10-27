package racingcar.domain.game;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.view.CarStatusDTO;
import racingcar.factory.CarFactory;
import racingcar.strategy.MoveStrategy;
import racingcar.domain.Constants;
import racingcar.error.CarsValidator;

public class Game {

  private final Cars cars;
  private final GameCount gameCount;

  public Game(String carNamesInput, String gameCountInput, MoveStrategy moveStrategy) {
    CarsValidator.validateCarNamesInput(carNamesInput);
    String[] carNames = carNamesInput.split(Constants.CAR_NAME_DELIMITER);
    CarsValidator.validateCarNames(carNames);
    List<Car> carList = CarFactory.createCars(carNames, moveStrategy);
    this.cars = new Cars(carList);
    this.gameCount = new GameCount(gameCountInput);
  }

  public void playRound() {
    this.cars.moveCars();
    this.gameCount.decrement();
  }

  public boolean canPlay() {
    return this.gameCount.canPlay();
  }

  public List<CarStatusDTO> getCurrentStatuses() {
    return this.cars.getCarStatuses();
  }

  public List<String> getWinners() {
    return this.cars.findWinners();
  }
}
