package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.view.RacingCarView;

public class RacingCarController {
    RacingCarView racingCarView;

    public RacingCarController(RacingCarView racingCarView) {
        this.racingCarView = racingCarView;
    }

    public void playGame() {
        RacingCars racingCars = initializeRacingCars();
        int trial = racingCarView.requestTrial();

        performRacingRounds(trial, racingCars.getRacingCars());
        racingCarView.displayWinners(racingCars.findWinners());
    }

    private RacingCars initializeRacingCars() {
        List<String> carNames = requestCarNames();
        racingCarView.startGameRound();
        return new RacingCars(carNames);
    }

    private void performRacingRounds(int trial, List<RacingCar> participants) {
        IntStream.range(0, trial).forEach(i -> playGameRound(participants));
    }

    private void playGameRound(List<RacingCar> participants) {
        participants.forEach(RacingCar::move);
        racingCarView.displayRacingCarStatus(participants);
    }

    private List<String> requestCarNames() {
        return racingCarView.requestCarNames();
    }
}
