package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RaceController {
    public void runRace(int attempts, List<Car> cars) {
        for (int i = 0; i < attempts; i++) {
            runSingleRound(cars);
            System.out.println();
        }
    }

    private void runSingleRound(List<Car> cars) {
        for (Car car : cars) {
            attemptCarMove(car);
            System.out.println(car);
        }
    }

    private void attemptCarMove(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.move();
        }
    }

    public void getWinner(List<Car> cars) {
        List<Integer> moveCounts = new ArrayList<>();

        for (Car car : cars) {
            moveCounts.add(car.getMoveCount());
        }

        int maxCount = Collections.max(moveCounts);
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (maxCount == car.getMoveCount()) {
                winners.add(car);
            }
        }

        printWinnerNames(winners);
    }

    private void printWinnerNames(List<Car> winners) {
        if (winners.size() == 1) {
            printSingleWinner(winners.getFirst());
        } else {
            printMultipleWinners(winners);
        }
    }

    private void printSingleWinner(Car car) {
        System.out.println("최종 우승자 : " + car.getName());
    }

    private void printMultipleWinners(List<Car> winners) {
        String result = String.join(", ",
                winners.stream()
                        .map(Car::getName)
                        .toArray(String[]::new));
        System.out.println("최종 우승자 : " + result);
    }
}
