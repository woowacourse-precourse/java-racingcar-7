package racingcar.racing;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.ErrorMessage;
import racingcar.util.Validator;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int MIN_RANDOM_NUMBER_RANGE = 0;
    private final int MAX_RANDOM_NUMBER_RANGE = 9;
    private List<Car> cars;
    private int attemptTimes;

    public Computer() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttemptTimes() {
        return attemptTimes;
    }

    public void prepareGame(List<Car> cars, int attemptTimes) {
        this.cars = new ArrayList<>(cars);
        this.attemptTimes = attemptTimes;
    }

    public void moveCars() {
        cars.forEach(car -> {
            if (shouldMove()) {
                car.movePosition();
            }
        });
    }

    public List<Car> determineWinners() {
        Validator.isNotEmptyCarList(cars);

        int maxPosition = findMaxPosition();

        return selectWinners(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.INVALID_POSITION_ERROR_MESSAGE.getMessage()));
    }

    private List<Car> selectWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }

        return winners;
    }

    private boolean shouldMove() {
        int randomNumber = pickRandomNumber();
        return Validator.canMove(randomNumber);
    }

    private int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER_RANGE, MAX_RANDOM_NUMBER_RANGE);
    }
}
