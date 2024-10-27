package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    ResultPrinter printer = new ResultPrinter();
    private static final int MOVEMENT_THRESHOLD = 4;

    public void playGames(List<Car> racingCar, int numberOfGames) {
        for (int i = 0; i < numberOfGames; i++) {
            updateResult(racingCar);
            printer.printRoundResult(racingCar);
        }
        printer.printWinners(decideWinner(racingCar));
    }

    public void updateResult(List<Car> racingCar) {
        for (Car car : racingCar) {
            if (moveForward()) {
                car.advance += 1;
            }
        }
    }

    public boolean moveForward() {
        return Randoms.pickNumberInRange(0, 9) >= MOVEMENT_THRESHOLD;
    }

    public String decideWinner(List<Car> racingCar) {
        int maxValue = Integer.MIN_VALUE;
        ArrayList<String> winnerList = new ArrayList<>();

        for (Car car : racingCar) {
            if (car.advance > maxValue) {
                maxValue = car.advance;
                winnerList.clear();
                winnerList.add(car.name);
            } else if (car.advance == maxValue) {
                winnerList.add(car.name);
            }
        }
        return String.join(", ", winnerList);
    }
}