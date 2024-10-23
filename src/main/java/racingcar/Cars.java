package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public int maxForward() {
        int max = 0;
        for (Car car : carList) {
            if (max < car.currentPosition()) {
                max = car.currentPosition();
            }
        }
        return max;
    }

    public List<Car> getWinner(int maxForward) {
        List<Car> winners = new ArrayList<>();
        for (Car car : carList) {
            if (car.isSameForward(maxForward)) {
                winners.add(car);
            }
        }
        return winners;
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
