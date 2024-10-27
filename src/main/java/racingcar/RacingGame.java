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
        GameResult result = new Game(cars, numberOfRounds).runRace();
        printPositions(result);
        announceWinner(result);
    }

    private void printPositions(GameResult result) {
        for (Car car : cars) {
            StringBuilder position = new StringBuilder(car.getName() + ": ");
            for (int i = 0; i < car.getPosition(); i++) {
                position.append("-");
            }
            System.out.println(position.toString());
        }
        System.out.println();
    }

    private void announceWinner(GameResult result) {
        List<Car> winners = result.getWinners();
        String winnerNames = getWinnerNames(winners);
        System.out.println("우승자: " + winnerNames);
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
