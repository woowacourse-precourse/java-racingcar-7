package racingcar.game;

import racingcar.strategy.MoveStrategy;
import racingcar.util.Printer;
import racingcar.exception.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class CarList {
    private static final String DELIMITER = ",";
    private static final String WINNER_FORMAT = ", ";

    private final MoveStrategy moveStrategy;
    private final List<Car> list;

    public CarList(MoveStrategy moveStrategy) {
        this.list = new ArrayList<>();
        this.moveStrategy = moveStrategy;
    }

    public void add(String carNames) {
        Validator.validateDelimiterFormatAndSingleRacer(carNames);
        Arrays.stream(carNames.split(DELIMITER))
                .map(Validator::validateNameLength)
                .map(name -> Car.generateCars(name, moveStrategy))
                .forEach(list::add);
    }

    public List<Car> moveCars(int count) {
        IntStream.range(0, count).forEach(i -> {
            list.forEach(Car::move);
            list.forEach(Printer::print);
            Printer.newLine();
        });
        return list;
    }

    public String getWinners(List<Car> matchResult) {
        return findWinners(matchResult.stream()
                .filter(car -> car.getPosition() == findMaxPosition(matchResult))
                .map(Car::getName)
                .toList());
    }

    private String findWinners(List<String> matchResult) {
        if (matchResult.size() != 1) {
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
