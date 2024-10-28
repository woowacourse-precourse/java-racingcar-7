package racingcar.presentation;

import racingcar.domain.Car;
import racingcar.application.RacingService;
import racingcar.common.io.Input;
import racingcar.common.io.Output;

import java.util.List;
import java.util.stream.Collectors;

public class RacingController {

  private final RacingService racingService;
  private final Input input;
  private final Output output;

  public RacingController() {
    this.racingService = new RacingService();
    this.input = new Input();
    this.output = new Output();
  }

  public void startGame() {
    List<Car> cars = createCars();
    int attempts = input.getAttempts();

    for (int i = 0; i < attempts; i++) {
      racingService.moveCars(cars);
      printRaceProgress(cars);
    }

    printWinners(cars);
  }

  private List<Car> createCars() {
    List<String> carNames = input.getCarNames();

    return carNames.stream()
        .map(Car::new)
        .toList();
  }

  private void printRaceProgress(List<Car> cars) {
    cars.forEach(car -> output.printRaceProgress(car.getName(), car.getPosition()));
    output.printMessage("");
  }

  private void printWinners(List<Car> cars) {
    List<Car> winners = racingService.findWinners(cars);
    List<String> winnerNames = winners.stream()
        .map(Car::getName)
        .toList();
    output.printWinners(winnerNames);
  }
}
