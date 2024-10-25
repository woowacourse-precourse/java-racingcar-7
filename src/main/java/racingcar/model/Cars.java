package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import racingcar.model.dto.CarStatusDto;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        validateDuplicate(cars);
        this.cars = cars;
    }

    public static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    public void move() {
        for (Car car : cars) {
            car.isMove();
        }
    }

    public List<CarStatusDto> getCarStatusResult() {
        List<CarStatusDto> racingResults = new ArrayList<>();
        for (Car car : cars) {
            CarStatusDto carStatus = car.mapStatusToDto();
            racingResults.add(carStatus);
        }
        return racingResults;
    }

    public List<String> findWinnersByMaxPosition() {
        int maxPosition = getMaxPosition();
        return addWinners(maxPosition);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    private List<String> addWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isMaxPosition(maxPosition)) {
                car.addWinner(winners);
            }
        }
        return winners;
    }

    private void validateDuplicate(List<Car> cars) {
        Set<Car> nonDuplicateCar = new HashSet<>(cars);
        if (nonDuplicateCar.size() != cars.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars);
    }
}
