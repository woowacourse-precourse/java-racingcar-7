package racingcar.service;


import racingcar.domain.Car;

import java.util.List;

public class WinnerDeterminer {

    public WinnerDeterminer() {
    }

    public List<Car> determineWinner(List<Car> carsAtFinish) {
        int maxPosition = getMaxPositionInCars(carsAtFinish);
        return getCarsAtMaxPosition(carsAtFinish, maxPosition);
    }

    private int getMaxPositionInCars(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Car> getCarsAtMaxPosition(List<Car> cars, int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
