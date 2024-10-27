package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;

    private final int rounds;

    public RacingGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }
}
