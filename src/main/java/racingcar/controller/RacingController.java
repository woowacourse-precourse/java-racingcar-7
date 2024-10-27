package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCars;
import racingcar.view.RacingCarView;

public class RacingController {

    public static void play() {
        RacingCars racingCars = initializeRacingCars();
        int attempts = RacingCarView.requestAttempts();

        RacingCarView.responseResultHeader();
        // TODO: RacingCar 들을 이동시키고 이동 결과 출력

        // TODO: 최종 우승자 출력
    }

    private static RacingCars initializeRacingCars() {
        List<String> carNames = RacingCarView.requestCarNames();
        return new RacingCars(carNames);
    }
}
