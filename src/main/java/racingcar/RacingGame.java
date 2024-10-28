package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int MIN_RANDOM_VALUE = 0;
    private static final int MAX_RANDOM_VALUE = 9;

    private final List<Car> participatingCars = new ArrayList<>();
    private final int attempts;

    public RacingGame(List<String> carNames, int attempts) {
        for (String name : carNames) {
            participatingCars.add(new Car(name.trim()));
        }
        this.attempts = attempts;
    }

    public void implement() {
        for (Car car : participatingCars) {
            int randomValue = Randoms.pickNumberInRange(MIN_RANDOM_VALUE, MAX_RANDOM_VALUE);
            car.move(randomValue);
        }
    }

    public List<String> getWinnerNames() {
        return findWinners(calculateMaxPosition());
    }

    public List<Car> getParticipatingCars() {
        return participatingCars;
    }

    private int calculateMaxPosition() {
        return participatingCars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(-1);
    }

    private List<String> findWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : participatingCars) {
            if (car.getLocation() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
