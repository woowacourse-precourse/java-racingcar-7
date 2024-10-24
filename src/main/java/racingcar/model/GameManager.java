package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.constant.ErrorMessage;

public class GameManager {

    private static final String CAR_NAME_DELIMITER = ",";

    private final List<Car> racers;

    private GameManager(List<Car> racers) {
        this.racers = racers;
    }

    private static void splitAndAddRacer(final List<Car> racers, final String input) {
        Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .forEach(carName -> {
                    racers.add(Car.from(carName));
                });
    }

    private static void validateRacerNotDuplicated(final List<Car> racers) {
        long distinctRacersCount = racers.stream().distinct().count();
        if (distinctRacersCount != racers.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATED.getMessage());
        }
    }

    public static GameManager from(final String input) {
        List<Car> racers = new ArrayList<>();
        splitAndAddRacer(racers, input);
        validateRacerNotDuplicated(racers);

        return new GameManager(racers);
    }
}