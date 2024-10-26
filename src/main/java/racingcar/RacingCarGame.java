package racingcar;

import java.util.List;

public class RacingCarGame {

    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;
    private final NumberGenerator numberGenerator;

    public RacingCarGame(InputHandler inputHandler,
                         OutputHandler outputHandler,
                         NumberGenerator numberGenerator) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
        this.numberGenerator = numberGenerator;
    }

    public void play() {
        List<CarName> carNames = inputHandler.inputCarNames();
        RacingCars racingCars = RacingCars.of(carNames);
        TryCount tryCount = inputHandler.inputTryCount();

        outputHandler.printResultMessage();
        for (int i = 0; i < tryCount.getValue(); i++) {
            racingCars.move(numberGenerator);
            outputHandler.printResult(racingCars.getRacingCars());
        }
        outputHandler.printWinners(racingCars.findWinners());
    }
}
