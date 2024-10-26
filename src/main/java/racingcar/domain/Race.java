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

    public Race(List<Car> Cars, int tryCount) {
        this.cars = new ArrayList<>();
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public int getWinnerPosition(List<Car> cars) {
        Car winner = Collections.max(cars, Comparator.comparingInt(car -> car.getPosition()));
        int winnerPosition = winner.getPosition();
        return winnerPosition;
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



}
