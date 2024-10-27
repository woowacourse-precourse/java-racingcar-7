package racingcar.controller;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.view.RacingCarView;

public class RacingCarController {

    public static void play() {
        RacingCars racingCars = initializeRacingCars();
        int attempts = RacingCarView.requestAttempts();

        RacingCarView.responseResultHeader();
        executeAllAttempts(racingCars, attempts);

        RacingCarView.responseWinnerRacingCars(racingCars.getFinalWinners());
    }

    private static RacingCars initializeRacingCars() {
        List<String> carNames = RacingCarView.requestCarNames();
        return new RacingCars(carNames);
    }

    private static void executeAllAttempts(RacingCars racingCars, int attempts) {
        IntStream.range(0, attempts).forEach(value -> {
            executeAttempt(racingCars);
            RacingCarView.responseRacingCarsResult(racingCars);
        });
    }

    private static void executeAttempt(RacingCars racingCars) {
        racingCars.getRacingCars()
                .forEach(RacingCar::move);
    }
}
