package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(List<String> carNames, int attempts) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.attempts = attempts;
    }

    public void playRound() {
        cars.forEach(car -> car.move(Randoms.pickNumberInRange(0, 9)));
    }

    public int getAttempts() {
        return attempts;
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
