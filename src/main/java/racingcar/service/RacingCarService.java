/*
 * RacingCarService
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
package racingcar.service;

import racingcar.domain.NumberOfAttempts;
import racingcar.domain.RacingCars;
import racingcar.dto.NumberOfAttemptsDTO;
import racingcar.view.OutputView;

public class RacingCarService {
    private final RacingCars racingCars;
    private final NumberOfAttempts numberOfAttempts;

    public RacingCarService(String readCarNames, String readNumberOfAttempts) {
        racingCars = new RacingCars(readCarNames);
        numberOfAttempts = new NumberOfAttempts(readNumberOfAttempts);
    }

    public void play(OutputView outputView) {
        NumberOfAttemptsDTO numberOfAttemptsDTO = numberOfAttempts.getNumberOfAttempts();
        int number = numberOfAttemptsDTO.getNumber();
        for (int i = 0; i < number; i++) {
            racingCars.move();
            String states = racingCars.getStates();
            outputView.printRacingCarsState(states);
        }
    }

    public String getWinners() {
        return racingCars.getWinners();
    }
}
