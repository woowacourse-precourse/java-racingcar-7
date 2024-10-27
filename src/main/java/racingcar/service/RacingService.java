package racingcar.service;

import racingcar.model.Car;
import racingcar.utils.Utils;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class RacingService {

    public void startRace(List<Car> cars, int tryNumber) {
        while (tryNumber-- > 0) {
            advanceMoveCar(cars);
            runResult(cars);
        }
    }

    public List<String> getWinners(List<Car> cars) {
        int max = cars.stream().mapToInt(Car::getMove).max().orElse(0);
        return findWinners(cars, max);
    }

    private List<String> findWinners(List<Car> cars, int max) {
        return cars.stream()
                .filter(car -> car.getMove() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void advanceMoveCar(List<Car> cars) {
        cars.forEach(this::moveCarAllowed);
    }

    private void moveCarAllowed(Car car) {
        if (Utils.advanceConditions()) {
            car.move();
        }
    }

    private void runResult(List<Car> cars) {
        OutputView.printRunResult(cars);
    }
}

