package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;

import java.util.List;

public class RacingCarController {
  private final InputView inputView;
  private final InputValidator inputValidator;

  public RacingCarController(InputView inputView, InputValidator inputValidator) {
    this.inputView = inputView;
    this.inputValidator = inputValidator;
  }
  public void run() {
    String carNameInput = inputView.askForCarName();
    inputValidator.validateCarNameInput(carNameInput);
    String attemptsInput = inputView.askForAttempts();
    inputValidator.validateAttemptsInput(attemptsInput);

    String[] carNames = carNameInput.split(",");
    inputValidator.validateEachCarName(carNames);
    inputValidator.validateAttemptCount(attemptsInput);
    int attemptsCount = Integer.parseInt(attemptsInput);

    List<Car> cars = CarService.createCars(carNames);
    CarService carService = new CarService(cars, attemptsCount);
    carService.startRace();
  }
}