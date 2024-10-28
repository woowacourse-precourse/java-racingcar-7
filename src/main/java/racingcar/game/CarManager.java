package racingcar.game;

import racingcar.util.Printer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {
    private static final String WINNER_FORMAT = ", ";

    private final List<Car> carList;

    private CarManager(List<String> carNames) {
        this.carList = carNames.stream()
                .map(Car::generateCars)
                .toList();
    }
    public static CarManager createManager(List<String> carNames) {
        return new CarManager(carNames);
    }

    public void moveCars() {
        carList.forEach(Car::move);
    }

    public void printCarListCurrentPosition() {
        carList.forEach(Printer::print);
        Printer.breakLine();
    }

    public String getWinners() {
        int maxPosition = findMaxPosition();
        return this.carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_FORMAT));
    }

    private int findMaxPosition() {
        List<Car> sortedList = new ArrayList<>(this.carList);
        sortedList.sort(Comparator.comparing(Car::getPosition).reversed());
        return sortedList.getFirst().getPosition();
    }
}
