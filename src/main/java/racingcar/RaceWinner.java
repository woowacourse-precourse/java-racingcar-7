package racingcar;

import java.util.List;

public class RaceWinner {

    private int findMaxPosition(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<String> findCarNames(List<Car> carList) {
        int maxPosition = findMaxPosition(carList);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }
}
