package racingcar.common.support;

import java.util.Comparator;
import racingcar.domain.CarRacer;

public class RacingCarComparator implements Comparator<CarRacer> {

    @Override
    public int compare(CarRacer car1, CarRacer car2) {
        return Integer.compare(
                car1.getProgressState().length(),
                car2.getProgressState().length()
        );
    }
}
