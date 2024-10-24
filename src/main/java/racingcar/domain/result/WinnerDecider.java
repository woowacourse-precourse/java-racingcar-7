package racingcar.domain.result;

import java.util.List;
import racingcar.domain.car.Car;

public class WinnerDecider {

    public static List<Car> decideWinners(List<Car> cars) {
        Integer maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car1 -> car1.getPosition() == maxPosition)
                .toList();
    }
}