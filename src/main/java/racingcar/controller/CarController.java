package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarService;
import racingcar.view.Input;
import racingcar.view.Output;

public class CarController {
    private Input input = new Input();
    private Output output = new Output();
    private CarService carService = new CarService();

    public void startGame() {
        List<Car> cars = makeCars();
        progressGame(cars);
        endGame(cars);
    }

    public List<Car> makeCars() {
        return carService.makeCars(input.readCarName());
    }

    public List<Car> progressGame(List<Car> cars) {
        carService.progressGame(cars, input.readTryNumber());
        output.printMessage();
        output.printIntermediateResult(carService.getIntermediateResult());
        return cars;
    }

    public void endGame(List<Car> cars) {
        output.printWinner(carService.getWinners(cars));
    }
}
