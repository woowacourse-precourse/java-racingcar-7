package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import racingcar.domain.Car;
import racingcar.domain.Race;

public class Service {
    private static final String COMMA = ",";

    public ArrayList<String> splitCarNames(final String carNames) {
        return new ArrayList<>(Arrays.stream(carNames.split(COMMA)).toList());
    }

    public void playRound(final Race race) {
        race.getCarArrayList().stream()
                .filter(Car::isMove)
                .forEach(Car::plusLocation);
    }
}
