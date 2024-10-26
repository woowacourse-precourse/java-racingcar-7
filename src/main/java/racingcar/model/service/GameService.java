package racingcar.model.service;

import racingcar.model.domain.Cars;

import java.util.Arrays;
import java.util.List;

public class GameService {

    private GameService() {
    }

    public static List<String> play(int playCnt, String carNames) {
        String[] names = carNames.split("\\s*,\\s*");
        Cars cars = Cars.from(Arrays.asList(names));

        for (int i = 0; i < playCnt; i++) {
            cars = cars.moveForward();
        }

        return cars.findWinners();
    }
}