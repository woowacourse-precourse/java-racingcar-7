package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class WinnerService {
    public List<Car> getWinners(Cars cars) {
        int maxPosition = getMaxPosition(cars);
        List<Car> carList = cars.getCars();

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(Cars cars) {
        List<Car> carList = cars.getCars();

        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
