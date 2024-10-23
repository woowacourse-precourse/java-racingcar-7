package racingcar.service;

import racingcar.domain.NumberOfAttempts;
import racingcar.domain.RacingCars;
import racingcar.view.OutputView;

public class RacingCarService {
    private final RacingCars racingCars;
    private final NumberOfAttempts numberOfAttempts;

    public RacingCarService(String readCarNames, String readNumberOfAttempts) {
        racingCars = new RacingCars(readCarNames);
        numberOfAttempts = new NumberOfAttempts(readNumberOfAttempts);
    }

    public void play(OutputView outputView) {
        int count = this.numberOfAttempts.getNumberOfAttempts();
        for (int i = 0; i < count; i++) {
            racingCars.move();
            outputView.printRacingCarsState(racingCars);
        }
    }
}
