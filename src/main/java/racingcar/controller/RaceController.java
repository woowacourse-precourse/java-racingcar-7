package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceTrack;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RaceTrack raceTrack;

    public RaceController(
            final InputView inputView,
            final OutputView outputView,
            final RaceTrack raceTrack
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.raceTrack = raceTrack;
    }

    public void run() {
        String carRegistrationRequest = getCarNames();
        int trialCount = getTrialCount();

        raceTrack.registerCars(carRegistrationRequest);
        playRace(trialCount);
        announceWinners();
    }

    private String getCarNames() {
        outputView.displayCarNameInputMessage();
        return inputView.getString();
    }

    private int getTrialCount() {
        outputView.displayTrialCountInputMessage();
        return inputView.getPositiveInteger();
    }

    private void playRace(int trialCount) {
        outputView.displayRoundResultMessage();
        for (int round = 0; round < trialCount; round++) {
            raceTrack.moveCars();
        }
    }

    private void announceWinners() {
        List<Car> winners = raceTrack.determineWinners();
        outputView.displayRaceResult(winners);
    }
}
