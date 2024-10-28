package racingcar.domain;

import racingcar.common.IOMessage;
import racingcar.common.Symbol;

import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private final List<Car> cars;

    public CarGroup(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    public void printCarPositions() {
        for (Car car : cars) {
            String positionMarker = Symbol.POSITION_MARKER.getSymbol().repeat(car.getPosition());
            System.out.printf(IOMessage.CAR_POSITION_FORMAT.getText() + "%n", car.getName(), positionMarker);
        }
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
