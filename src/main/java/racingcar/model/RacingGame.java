package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(List<Car> cars, int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        this.cars = cars;
        this.attempts = attempts;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttempts() {
        return attempts;
    }

    public void playRound() {
        cars.forEach(car -> car.move(generateRandomNumber() >= 4));
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9); // 0~9 범위의 난수
    }

    public int findMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public String findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }
}
