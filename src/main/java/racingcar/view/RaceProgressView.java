package racingcar.view;

import java.util.List;
import racingcar.RacingCar;

public class RaceProgressView {
    private final String COLON_DELIMITER = " : ";

    public void displayRoundProgress(List<RacingCar> racingCars) {
        System.out.println();
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getName() + COLON_DELIMITER + racingCar.getDistance());
        }
    }

}
