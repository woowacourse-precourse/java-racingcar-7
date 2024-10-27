package racingcar;

import java.util.Comparator;

public class CarComparator implements Comparator<Car> {
    @Override
    public int compare(Car c1, Car c2) {
        return Integer.compare(c1.getAdvanceCount(), c2.getAdvanceCount());
    }
}
