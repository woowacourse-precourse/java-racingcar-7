package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameBoard {
    private static final String DELIMITER_OF_CAR_NAMES = ",";
    private static final String SYMBOL_OF_EACH_TRY_FORMAT = " : ";
    private static final String NEW_LINE = "\n";
    private final Cars cars;

    private GameBoard(Cars cars) {
        this.cars = cars;
    }

    public static GameBoard from(String input) {
        List<String> carNames = Arrays.asList(input.split(DELIMITER_OF_CAR_NAMES));
        List<Car> cars = carNames.stream().map(Car::from).toList();
        return new GameBoard(Cars.from(cars));
    }

    public String makeCarPositions() {
        cars.moveEachCar();
        return cars.getCars().stream()
                .map(car -> car.getName() + SYMBOL_OF_EACH_TRY_FORMAT + car.getMoveStatus())
                .collect(Collectors.joining(NEW_LINE));
    }
}
