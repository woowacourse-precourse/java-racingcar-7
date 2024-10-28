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
    private final List<RacingResult> racingResults;


    public RacingGame(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.racingResults = new ArrayList<>();
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
    public boolean hasNextRound() {
        return currentRound < tryCount;
    }

    public RaceRound playRound() {
        for (Car car : cars) {
            int randomValue = randomNumberGenerator.generateNumber(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            car.move(randomValue);
        }
        List<String> currentResults = cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.toList());
        racingResults.add(new RacingResult(currentResults));
        currentRound++;
        return new RaceRound(currentRound);
    }
    public List<List<String>> getAllRoundResults() {
        return racingResults.stream()
                .map(RacingResult::getRoundResults)
                .collect(Collectors.toList());
    }

}
