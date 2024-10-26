package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.parser.InputParser;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {
    private final RacingGameService racingGameService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputParser inputParser;

    public RacingGameController(
            RacingGameService racingGameService,
            InputView inputView,
            OutputView outputView,
            InputParser inputParser) {
        this.racingGameService = racingGameService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputParser = inputParser;
    }

    public void run() {
        outputView.displayCarNameInput();
        String inputValue = inputView.inputCarNames();
        List<Car> CarNames = inputParser.parseCarNames(inputValue);
    }


}
