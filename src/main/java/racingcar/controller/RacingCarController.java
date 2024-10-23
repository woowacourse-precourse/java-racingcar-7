package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarCollection;
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
            CarCollection cars = initializeCars();
            int rounds = input.getRaceRounds();
            output.printStartMessage();
            runRoundsAndDisplayResults(cars, rounds);
            printWinners(cars);
        } finally {
            output.close();
        }
    }

    private CarCollection initializeCars() {
        String carNamesInput = input.getCarNames();
        return CarCollection.from(carNamesInput);
    }

    private void runRoundsAndDisplayResults(CarCollection cars, int rounds) {
        for (int i = 0; i < rounds; i++) {
            cars.moveAll();
            output.printRoundResult(cars);
        }
    }

    private void printWinners(CarCollection cars) {
        List<Car> winners = cars.getWinners();
        output.printWinners(winners);
    }
}
