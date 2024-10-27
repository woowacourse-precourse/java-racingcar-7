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

    public List<Car> makeCars() {
        return carService.makeCars(input.readCarName());
    }

    public List<Car> progressGame(List<Car> cars) {
        int tryNumber = input.readTryNumber();
        output.printMessage();
        while (tryNumber-- > 0) {
            carService.moveCarsIfConditionMet(cars);
            output.printIntermediateResult(cars);
        }
        return cars;
    }

    public void endGame(List<Car> cars) {
        output.printWinner(carService.getWinners(cars));
    }
}
