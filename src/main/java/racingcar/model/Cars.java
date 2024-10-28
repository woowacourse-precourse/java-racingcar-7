package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constant.ErrorMessages;
import racingcar.util.DefaultRandomGenerator;
import racingcar.util.RandomGenerator;

public class Cars {
    private static final int MOVE_THRESHOLD = 4;

    private final List<Car> carList;
    private final RandomGenerator randomGenerator;

    public Cars(List<Car> carList) {
        this(carList, new DefaultRandomGenerator());
    }

    public Cars(List<Car> carList, RandomGenerator randomGenerator) {
        this.carList = carList;
        this.randomGenerator = randomGenerator;
    }

    public void tryMoveAll() {
        carList.forEach(car -> {
            int randomNumber = randomGenerator.generate();
            car.move(isMovable(randomNumber));
        });
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVE_THRESHOLD;
    }

    public List<String> getRaceWinner() {
        int max = getMaxPosition();
        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessages.BLANK_INPUT));
    }

    @Override
    public String toString() {
        return carList.stream()
                .map(Car::toString)
                .collect(Collectors.joining("\n"))
                + "\n";
    }
}
