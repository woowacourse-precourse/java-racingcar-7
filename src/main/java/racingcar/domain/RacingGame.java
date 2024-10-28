package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int RANDOM_START_INCLUSIVE = 0;
    private static final int RANDOM_END_INCLUSIVE = 9;

    private final List<Car> cars;
    private final int totalRounds;
    private int currentRound = 0;

    public RacingGame(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
    }

    public boolean hasNextRound() {
        return currentRound < totalRounds;
    }

    public void playRound() {
        moveCars();
        currentRound++;
    }

    private void moveCars() {
        for (Car car : cars) {
            int randomNumber = generateRandomNumber();
            car.move(randomNumber);
        }
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return extractWinners(maxPosition);
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private List<String> extractWinners(int maxPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            addWinnerIfApplicable(winners, car, maxPosition);
        }
        return winners;
    }

    private void addWinnerIfApplicable(List<String> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }
}