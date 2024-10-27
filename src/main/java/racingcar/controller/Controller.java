package racingcar.controller;

import racingcar.domain.car.CarType;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.RacingConfig;
import racingcar.dto.UserInput;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        UserInput userInput = inputView.prompt();

        RacingConfig racingConfig = new RacingConfig(userInput.cars(), userInput.rounds(), CarType.RANDOM);
        Racing racing = new Racing(racingConfig);

        long attemptCount = racing.getTotalRounds();
        for (long i = 0; i < attemptCount; i++) {
            racing.playRound();
            outputView.displayCurrentPosition(racing.getCurrentPosition());
        }

        outputView.displayResult(racing.getFirstPlaceCar());
    }
}
