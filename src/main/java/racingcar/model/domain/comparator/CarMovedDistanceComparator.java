package racingcar.model.domain.comparator;

import java.util.Comparator;
import racingcar.model.domain.Car;

public class CarMovedDistanceComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return Integer.compare(o2.getMovedDistance(), o1.getMovedDistance());
    }
}
