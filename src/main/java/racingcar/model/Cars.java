package racingcar.model;

import static racingcar.util.constant.MoveCarNumberConstant.CAR_IS_NOT_STARTED_YET;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import racingcar.exception.TheCarDoesntStartException;
import racingcar.exception.carName.DuplicateCarNameException;
import racingcar.service.GameService;

public record Cars(List<Car> cars) {

    public Cars moveOneTurn(GameService gameService) {
        List<Car> turnEndResults = cars.stream()
                .map(car -> {
                    if (gameService.isMoving()) {
                        return car.move();
                    }
                    return car;
                })
                .toList();

        return new Cars(turnEndResults);
    }

    public boolean duplicateValidation() {
        Set<Car> deduplicationCars = new HashSet<>(cars);
        if (cars.size() != deduplicationCars.size()) {
            throw new DuplicateCarNameException();
        }
        return true;
    }

    public List<String> carsToString() {
        return cars.stream().map(Car::toString).toList();
    }

    public List<String> carsToName() {
        return cars.stream().map(Car::name).toList();
    }

    public Cars sortCarsToDescendingOrder() {
        List<Car> sortedCars = new ArrayList<>(cars);
        sortedCars.sort(Comparator.comparingInt(Car::distance).reversed());
        return new Cars(sortedCars);
    }

    public Cars findWinners() {
        int firstPlaceRecord = cars.getFirst().distance();
        isRaceStarted(firstPlaceRecord);
        List<Car> winners = cars.stream()
                .takeWhile(car -> car.distance() == firstPlaceRecord)
                .toList();

        return new Cars(winners);
    }

    private boolean isRaceStarted(final int firstPlaceRecord) {
        if (firstPlaceRecord == CAR_IS_NOT_STARTED_YET.getValue()) {
            throw new TheCarDoesntStartException();
        }
        return true;
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
        return Objects.equals(cars(), cars1.cars());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cars());
    }
}
