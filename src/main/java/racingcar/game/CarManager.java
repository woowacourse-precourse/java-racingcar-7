package racingcar.game;

import racingcar.util.Printer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CarManager {
    private static final String WINNER_FORMAT = ", ";
    private static final int SINGLE_WINNER = 1;

    private final List<Car> list;

    private CarManager(List<String> carNames) {
        this.list = carNames.stream()
                .map(Car::generateCars)
                .toList();
    }
    public static CarManager createManager(List<String> carNames) {
        return new CarManager(carNames);
    }

    public void moveCars() {
        list.forEach(Car::move);
    }

    public void printCarListCurrentPosition() {
        list.forEach(Printer::print);
        Printer.breakLine();
    }

    public String getWinners(List<Car> matchResult) {
        return findWinners(matchResult.stream()
                .filter(car -> car.getPosition() == findMaxPosition(matchResult))
                .map(Car::getName)
                .toList());
    }

    private String findWinners(List<String> matchResult) {
        if (matchResult.size() != SINGLE_WINNER) {
            return String.join(WINNER_FORMAT, matchResult);
        }
        return matchResult.getFirst();
    }

    private int findMaxPosition(List<Car> matchResult) {
        List<Car> sortedList = new ArrayList<>(matchResult);
        sortedList.sort(Comparator.comparing(Car::getPosition).reversed());
        return sortedList.getFirst().getPosition();
    }
}
