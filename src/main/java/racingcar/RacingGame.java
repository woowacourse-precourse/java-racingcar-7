package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int numberOfRounds;

    public RacingGame(List<Car> cars, int numberOfRounds) {
        this.cars = cars;
        this.numberOfRounds = numberOfRounds;
    }

    public void startRace() {
        for (int i = 0; i < numberOfRounds; i++) {
            moveCars();
            printPositions();
        }
        announceWinner();
    }

    private void moveCars() {
        for (Car car : cars) {
            boolean isForward = shouldMove();
            car.move(isForward);
        }
    }

    private boolean shouldMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    private void printPositions() {
        for (Car car : cars) {
            StringBuilder position = new StringBuilder(car.getName() + ": ");
            for (int i = 0; i < car.getPosition(); i++) {
                position.append("-");
            }
            System.out.println(position.toString());
        }
        System.out.println();
    }

    private void announceWinner() {
        List<Car> winners = getWinners();
        String winnerNames = getWinnerNames(winners);
        System.out.println("우승자: " + winnerNames);
    }

    private List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private String getWinnerNames(List<Car> winners) {
        StringBuilder names = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            names.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                names.append(", ");
            }
        }
        return names.toString();
    }
}
