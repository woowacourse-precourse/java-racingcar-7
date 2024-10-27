package racingcar.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.util.RandomUtil;

public class Cars {

    private final List<Car> carList;

    public Cars(final List<Car> carList) {
        checkDuplicateCarName(carList);
        this.carList = carList;
    }

    private void checkDuplicateCarName(List<Car> carList) {
        if (hasDuplicateName(carList)) {
            throw new IllegalArgumentException("중복되는 자동차 이름은 사용할 수 없습니다");
        }
    }

    private boolean hasDuplicateName(List<Car> carList) {
        Set<Car> carSet = new HashSet<>(carList);
        return carSet.size() < carList.size();
    }

    public void takeTurn() {
        carList.forEach(car -> car.decideMove(RandomUtil.pickRandom()));
    }

    public List<String> findWinners() {
        int maxMove = calculateMaxMoves();
        return carList.stream()
                .filter(car -> car.isSameMaxMove(maxMove))
                .map(Car::getName)
                .toList();
    }

    private int calculateMaxMoves() {
        int maxMove = 0;

        for (Car car : carList) {
            maxMove = car.getMaxMove(maxMove);
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
