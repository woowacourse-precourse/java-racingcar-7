package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        this.carList = carList;
    }

    public List<String> findWinners() {
        return carList.stream().filter(car -> car.isSameForward(maxForward()))
                .map(Car::getName)
                .toList();
    }

    private int maxForward() {
        int max = 0;

        for (Car car : carList) {
            max = car.comparePosition(max);
        }

        return max;
    }

    public Cars decideMoving() {
        for (Car car : carList) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
        return this;
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : carList) {
            stringBuilder.append(car.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
