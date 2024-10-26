package racingcar.controller;

import java.util.List;
import racingcar.dto.RaceResult;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;
    private final StringSplitter stringSplitter;
    private final NumberParser numberParser;

    public RacingController(
            InputView inputView,
            OutputView outputView,
            RacingService racingService,
            StringSplitter stringSplitter,
            NumberParser numberParser
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
        this.stringSplitter = stringSplitter;
        this.numberParser = numberParser;
    }

    public void run() {
        List<String> carNames = stringSplitter.split(inputView.getCarNames());
        int roundCount = numberParser.parse(inputView.getTotalRace());

        RaceResult result = racingService.createAndExecute(carNames, roundCount);

        outputView.printRoundResults(result.raceHistory());
        outputView.printWinners(result.winners());
    }
}
