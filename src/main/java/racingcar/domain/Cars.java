package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racingcar.util.RandomUtil;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        this.carList = carList;
    }

    public void takeTurn() {
        carList.forEach(car -> car.decideMove(RandomUtil.pickRandom()));
    }

    public List<String> findWinners() {
        int maxMove = calculateMaxMove();
        return carList.stream()
                .filter(car -> car.isSameMaxMove(maxMove))
                .map(Car::getName)
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

    @Override
    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining());
    }

}
