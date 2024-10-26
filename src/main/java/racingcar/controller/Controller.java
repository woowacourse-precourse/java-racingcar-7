package racingcar.controller;

import java.util.stream.IntStream;
import racingcar.domain.Race;
import racingcar.service.RaceService;
import racingcar.view.OutputView;

public class Controller {
    private final RaceService raceService;
    private final OutputView outputView;

    public Controller(final RaceService raceService, final OutputView outputView) {
        this.raceService = raceService;
        this.outputView = outputView;
    }

    public void playRound(final Race race) {
        IntStream.range(0, race.getAttemptCount()).forEach(attemptCount -> {
            raceService.playRound(race);
            printRoundResult(race);
        });
    }

    private void printRoundResult(final Race race) {
        outputView.printEndLine();
        outputView.printGameResultMessage();
        race.getCarList().forEach(outputView::printRoundResult);
        outputView.printEndLine();
    }
}
