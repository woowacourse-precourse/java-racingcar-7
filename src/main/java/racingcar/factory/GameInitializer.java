package racingcar.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarGroup;
import racingcar.domain.game.GameRound;

public abstract class GameInitializer {

    private static final String DELIMITER = ",";

    public static CarGroup createCars(String carNames) {
        List<Car> carList = Arrays.stream(carNames.split(DELIMITER))
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
        return new CarGroup(carList);
    }

    public static GameRound setRound(String roundInput) {
        return new GameRound(roundInput);
    }
}
