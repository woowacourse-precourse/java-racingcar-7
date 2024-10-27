package racingcar.domain;

import java.util.List;
import racingcar.domain.Car.Car;
import racingcar.domain.Car.Cars;
import racingcar.io.Input.InputHandler;
import racingcar.io.Output.OutputHandler;

public class Racing {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    private final Cars cars;
    private Round round;

    public Racing(InputHandler inputHandler, OutputHandler outputHandler, Cars cars, Round round) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.cars = cars;
        this.round = round;
    }

    public void start() {

        outputHandler.printCarNameRequest();

        String input = inputHandler.inputCarNameList();

        String[] carNameList = input.split(",", -1);

        cars.addCar(carNameList);

        outputHandler.printRoundRequest();

        round.updateRound(inputHandler.inputRoundNumber());

        for (int i = 0; i < round.getRound(); i++) {
            cars.moveForward();
            cars.printRacingProgress(outputHandler);
        }

        List<Car> winners = cars.getWinners();

        outputHandler.printWinners(winners);
    }
}
