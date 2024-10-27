package racingcar.controller;

import java.util.List;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.service.RaceGameService;
import racingcar.util.parser.InputStringParser;
import racingcar.util.parser.StringParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceGameService raceGameService;

    public RaceGameController(
            final InputView inputView,
            final OutputView outputView,
            final RaceGameService raceGameService
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceGameService = raceGameService;
    }

    public void run() {
        String racerNames = requestInputStringRacerName();
        List<Car> cars = raceGameService.enrollRacer(racerNames, new StringParser());
    }

    private String requestInputStringRacerName() {
        outputView.printAskInputRacerName();
        return inputView.read();
    }
}
