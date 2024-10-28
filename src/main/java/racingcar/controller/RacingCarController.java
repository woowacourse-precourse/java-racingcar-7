package racingcar.controller;

import java.util.List;
import racingcar.domain.Race;
import racingcar.domain.RaceResult;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Race race;

    public RacingCarController(InputView inputView, OutputView outputView, Race race) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.race = race;
    }

    public void run() {
        outputView.startMessage();
        List<Car> racingCars = inputView.getNames();

        outputView.trialCountMessage();
        int numberOfTries = inputView.getTrialNumber();

        for (int i = 0; i < numberOfTries; i++) {
            race.race(racingCars);
            outputView.showRaceStatus(racingCars);
        }

        List<Car> winners = RaceResult.getWinners(racingCars);
        outputView.finalWinnerMessage(winners);
    }
}
