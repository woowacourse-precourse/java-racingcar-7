package racingcar.presentation;

import racingcar.domain.Car;
import racingcar.application.RacingService;
import racingcar.common.io.Input;
import racingcar.common.io.Output;

import java.util.List;
import racingcar.domain.dto.CarDTO;

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
      List<CarDTO> carDTOs = racingService.getCarDTOs(cars);
      printRaceProgress(carDTOs);
    }

    List<CarDTO> winners = racingService.findWinners(racingService.getCarDTOs(cars));
    printWinners(winners);
  }

  private List<Car> createCars() {
    List<String> carNames = input.getCarNames();

    return carNames.stream().map(Car::new).toList();
  }

  private void printRaceProgress(List<CarDTO> carDTOs) {
    carDTOs.forEach(output::printRaceProgress);
    output.printMessage("");
  }

  private void printWinners(List<CarDTO> winners) {
    List<String> winnerNames = winners.stream().map(CarDTO::name).toList();
    output.printWinners(winnerNames);
  }
}
