package racingcar.controller;

import racingcar.domain.Race;
import racingcar.util.CarNameParser;
import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

import java.util.List;

import static racingcar.constants.OutputMessages.ASK_CAR_NAMES;
import static racingcar.constants.OutputMessages.ASK_TRY_COUNT;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printMessage(ASK_CAR_NAMES);
        String input = inputView.userInput();
        List<String> carNames = CarNameParser.parse(input);

        outputView.printMessage(ASK_TRY_COUNT);
        int tryCount = Integer.parseInt(inputView.userInput());

        startRace(carNames, tryCount);
    }

    private void startRace(List<String> carNames, int tryCount) {
        Race race = new Race(carNames);
    }
}
