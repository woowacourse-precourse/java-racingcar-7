package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {
    private static final String DELIMITER_OF_CAR_NAMES = ",";
    private final Cars cars;

    private GameBoard(Cars cars) {
        this.cars = cars;
    }

    public static GameBoard from(String input) {
        List<String> carNames = Arrays.asList(input.split(DELIMITER_OF_CAR_NAMES));
        List<Car> cars = carNames.stream().map(Car::from).toList();
        return new GameBoard(Cars.from(cars));
    }
}
