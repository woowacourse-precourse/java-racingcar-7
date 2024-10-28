package racingcar.domain;

import racingcar.utils.RandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int INITIAL_ROUND = 0;
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private List<Car> cars;
    private int tryCount;
    private int currentRound;
    private final RandomNumberGenerator randomNumberGenerator;

    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void initialize(String carNames, int tryCount) {
        this.cars = createCars(carNames);
        this.tryCount = tryCount;
        this.currentRound = INITIAL_ROUND;
    }

    private List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

}
