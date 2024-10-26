package racingcar.domain;

import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> findWinners() {
        int maxMove = calculateMaxMove();
        return carList.stream()
                .filter(car -> car.isSameMaxMove(maxMove))
                .toList();
    }

    private int calculateMaxMove() {
        int maxMove = 0;

        for (Car car : carList) {
            maxMove = car.getLargerMove(maxMove);
        }

        return maxMove;
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
