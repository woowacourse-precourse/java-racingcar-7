package racingcar.controller;

import racingcar.domain.*;
import racingcar.dto.GameResult;
import racingcar.service.RacingService;
import racingcar.util.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    public void run() {
        String input = InputView.inputCars();
        List<String> carNames = Parser.parse(input);
        int rounds = InputView.inputRounds();
        GameResult results = racingService.play(carNames, new RandomMoveCondition(), rounds);
        OutputView.printResult(results);
    }
}
