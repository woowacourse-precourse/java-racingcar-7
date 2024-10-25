package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        this.carList = carList;
    }

    public int maxForward() {
        int max = 0;

        for (Car car : carList) {
            max = car.comparePosition(max);
        }

        return max;
    }

    public List<Car> maxForwardCars(int max) {
        return carList.stream().filter(car -> car.isSameForward(max)).toList();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Cars cars)) {
            return false;
        }
        return Objects.equals(carList, cars.carList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carList);
    }

}
