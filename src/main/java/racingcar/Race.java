package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    private final Validator validator;
    private final View view;

    public Race(Validator validator, View view) {
        this.validator = validator;
        this.view = view;
    }

    public void run() {
        List<Car> cars = validator.validateAndParseCarNames(view.scanCarNames());

        int attemptCount = validator.validateAndParseInteger(view.scanAttemptCount(cars));
        validator.validatePositive(attemptCount);

        startRace(cars, attemptCount);

        List<String> winners = getWinners(cars, getMaxDistance(cars));
        view.printWinners(winners);
    }

    public void startRace(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            moveCars(cars);
            view.printCarsProgress(cars);
        }
    }

    public void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.forward();
            }
        }
    }

    public boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(car.getProgress().length(), maxDistance);
        }
        return maxDistance;
    }

    public List<String> getWinners(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.getProgress().length()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
