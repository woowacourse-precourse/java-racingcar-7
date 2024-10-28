package racingcar.application.service;

import java.util.Comparator;
import racingcar.racing.RacingCar;

public class RacingCarComparator implements Comparator<RacingCar> {

    @Override
    public int compare(RacingCar car1, RacingCar car2) {
        return Integer.compare(
                car1.getProgressState().length(),
                car2.getProgressState().length()
        );
    }
}
