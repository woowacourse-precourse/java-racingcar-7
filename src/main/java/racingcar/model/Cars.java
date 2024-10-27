package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import racingcar.exception.ErrorMessage;
import racingcar.model.dto.CarStatusDto;
import racingcar.util.randomnumber.RandomNumberGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromNames(List<String> carsNames) {
        validateDuplicate(carsNames);
        return Cars.fromCars(createCars(carsNames));
    }

    protected static Cars fromCars(List<Car> cars) {
        return new Cars(cars);
    }

    private static void validateDuplicate(List<String> carNames) {
        Set<String> nonDuplicateCarNames = new HashSet<>(carNames);
        if (nonDuplicateCarNames.size() != carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
        }
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, new RandomNumberGenerator()));
        }
        return cars;
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
            maxPosition = car.findMaxPosition(maxPosition);
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
