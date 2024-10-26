package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import racingcar.util.RandomNumber;
import racingcar.util.Validator;

public class Race {

    private final List<Car> cars;
    private final int tryCount;
    private final static int MAX_CAR_NAME_LENGTH = 5;
    private final static int VALIDATE_NEGATIVE_NUMBER = 0;

    public Race(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        int winnerPosition = getWinnerPosition(cars);
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public void playRace() {
        for (int i = 0; i < tryCount; i++) {
            playOneRound(cars);
        }
    }

    private void playOneRound(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = RandomNumber.generateRandomNumber();
            if (Validator.isMoreFour(randomNumber)) {
                car.move();
            }
        }
    }

    private int getWinnerPosition(List<Car> cars) {
        Car winner = Collections.max(cars, Comparator.comparingInt(car -> car.getPosition()));
        int winnerPosition = winner.getPosition();
        return winnerPosition;
    }

    public static boolean validateCarName(String name) {
        int nameLength = name.length();
        if (nameLength > MAX_CAR_NAME_LENGTH) {
            return false;
        }
        return true;
    }

    public static boolean validateTryCount(int tryCount) {
        if (tryCount < VALIDATE_NEGATIVE_NUMBER) {
            return false;
        }
        return true;
    }
}
