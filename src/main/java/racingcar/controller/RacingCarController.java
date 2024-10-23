package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarCollection;
import racingcar.domain.CarName;
import racingcar.io.input.Input;
import racingcar.io.output.Output;

public class RacingCarController {
    private final Input input;
    private final Output output;

    public RacingCarController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void start() {
        try {
            String carNamesInput = input.getCarNames();
            CarCollection cars = createCars(carNamesInput);

            int rounds = input.getRaceRounds();
            output.printStartMessage();

            for (int i = 0; i < rounds; i++) {
                cars.moveAll();
                output.printRoundResult(cars);
            }

            List<Car> winners = cars.getWinners();
            output.printWinners(winners);
        } catch (IllegalArgumentException e) {
            output.printErrorMessage(e.getMessage());
        }
    }

    private CarCollection createCars(String input) {
        List<Car> carList = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(CarName::new)
                .map(Car::new)
                .collect(Collectors.toList());
        return new CarCollection(carList);
    }
}
