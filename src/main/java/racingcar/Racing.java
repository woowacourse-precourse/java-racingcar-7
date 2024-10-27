package racingcar;

import java.util.List;
import racingcar.Input.InputHandler;
import racingcar.Output.OutputHandler;

public class Racing {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public Racing(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void start() {

        outputHandler.printCarNameRequest();

        String input = inputHandler.inputCarNameList();

        String[] carNameList = input.split(",", -1);

        Cars cars = new Cars();

        cars.addCar(carNameList);

        outputHandler.printRoundRequest();

        Round round = new Round(inputHandler.inputRoundNumber());

        for (int i = 0; i < round.getRound(); i++) {
            cars.moveForward();
            cars.printRacingProgress(outputHandler);
        }

        List<Car> winners = cars.getWinners();

        outputHandler.printWinners(winners);
    }
}
