package racingcar.domain;

import racingcar.util.Util;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.OutputView.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            boolean canGo = Util.isCanGo();
            if (canGo) {
                car.move();
            }
            printCarStatus(car);
        }
        lineSeparator();
    }

    public List<String> findWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getCarPosition)
                .max()
                .orElse(0);

        return getMaxPositionCarName(maxPosition);
    }

    private List<String> getMaxPositionCarName(final Integer maxPosition) {

        if (maxPosition == 0) {
            return List.of(new String[]{});
        }

        return cars.stream()
                .filter(car -> car.getCarPosition().equals(maxPosition))
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

}
