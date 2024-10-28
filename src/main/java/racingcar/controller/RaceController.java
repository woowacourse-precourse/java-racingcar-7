package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.RaceTrack;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private static final String CAR_NAME_SEPARATOR = ",";

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
        List<String> carNames = getCarNames();
        int trialCount = getTrialCount();

        raceTrack.registerCars(carNames);
        playRace(trialCount);
        announceWinners();
    }

    private List<String> getCarNames() {
        outputView.displayCarNameInputMessage();
        String carRegistrationRequest = inputView.getString();
        return parseCarNames(carRegistrationRequest);
    }

    private List<String> parseCarNames(String carRegistrationRequest) {
        return List.of(carRegistrationRequest.split(CAR_NAME_SEPARATOR));
    }

    private int getTrialCount() {
        outputView.displayTrialCountInputMessage();
        return inputView.getPositiveInteger();
    }

    private void playRace(int trialCount) {
        outputView.displayRoundResultMessage();
        for (int round = 0; round < trialCount; round++) {
            playSingleRound();
        }
    }

    private void playSingleRound() {
        raceTrack.tryMoveAllCars();
        outputView.displayRoundResult(raceTrack.getCars());
    }

    private void announceWinners() {
        List<Car> winners = raceTrack.determineWinners();
        outputView.displayRaceResult(winners);
    }
}
