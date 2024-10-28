package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Race {
    public void run() {
        String carNamesInput = View.scanCarNames();
        List<Car> cars = Validator.validateAndParseCarNames(carNamesInput);

        String attemptCountInput = View.scanAttemptCount(cars);
        int attemptCount = Validator.validateAndParseInteger(attemptCountInput);
        Validator.validatePositive(attemptCount);

        startRace(cars, attemptCount);

        List<String> winners = getWinners(cars, getMaxDistance(cars));
        View.printWinners(winners);
    }

    void startRace(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            moveCars(cars);
            View.printCarsProgress(cars);
        }
    }

    void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.forward();
            }
        }
    }

    boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    int getMaxDistance(List<Car> cars) {
        int maxDistance = 0;
        for (Car car : cars) {
            maxDistance = Math.max(car.getProgress().length(), maxDistance);
        }
        return maxDistance;
    }

    List<String> getWinners(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (maxDistance == car.getProgress().length()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
