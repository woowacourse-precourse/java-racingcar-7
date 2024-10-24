package racingcar.controller;

import racingcar.domain.CarCollection;
import racingcar.domain.Round;
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
            Round rounds = input.getRaceRounds();
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

    private void runRoundsAndDisplayResults(CarCollection cars, Round rounds) {
        for (int i = 0; i < rounds.value(); i++) {
            cars.moveAll();
            output.printRoundResult(cars);
        }
    }

    private void printWinners(CarCollection cars) {
        output.printWinners(cars);
    }
}
