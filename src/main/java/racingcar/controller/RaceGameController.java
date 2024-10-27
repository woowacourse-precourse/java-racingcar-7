package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;
import racingcar.domain.TrialCount;
import racingcar.service.RaceGameService;
import racingcar.util.generator.RandomNumberGenerator;
import racingcar.util.parser.InputStringParser;
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
        List<Car> cars = raceGameService.enrollRacer(racerNames, new InputStringParser());

        final TrialCount trialCount = requestInputTrialCount();
        progressGame(trialCount.getAmount(), cars);

        List<Car> winner = raceGameService.findWinner(cars);
    }

    private void progressGame(final int trialCount, List<Car> cars) {
        outputView.printRoundResultStart();
        for (int i = 0; i < trialCount; i++) {
            raceGameService.progressRound(cars, new Referee(new RandomNumberGenerator()));
            outputView.printRoundResultDetail(cars);
        }
    }

    private String requestInputStringRacerName() {
        outputView.printAskInputRacerName();
        return inputView.read();
    }

    private TrialCount requestInputTrialCount() {
        outputView.printAskInputTrialCount();
        return new TrialCount(inputView.read());
    }
}
