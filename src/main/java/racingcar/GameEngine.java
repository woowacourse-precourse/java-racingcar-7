package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameEngine {

    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator randomNumberGenerator;
    private static final int MOVE_STANDARD = 4;

    public GameEngine(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void initializeCars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void execute(int times) {
        for (int i = 0; i < times; i++) {
            move();
            OutputHandler.printOneBlankLine();
        }
    }

    private void move() {
        for (Car car : cars) {
            if (randomNumberGenerator.generate() >= MOVE_STANDARD) {
                car.increaseCount();
            }
            OutputHandler.printExecuteResult(car.toString());
        }
    }

    public List<String> findWinnerCarNames() {
        int maxCount = cars.stream().mapToInt(Car::getCount).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getCount() == maxCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
