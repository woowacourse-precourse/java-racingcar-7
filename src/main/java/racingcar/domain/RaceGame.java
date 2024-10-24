package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private final List<Car> cars;
    private final int totalRound;
    private int currentRound;
    private final GenerateNumberStrategy numberStrategy;

    public RaceGame(List<Car> cars, int totalRound, GenerateNumberStrategy numberStrategy) {
        this.cars = cars;
        this.totalRound = totalRound;
        this.currentRound = 1;
        this.numberStrategy = numberStrategy;
    }

    public void run() {
        for (int i = 0; i < totalRound; i++) {

            race();
        }
    }

    private void race() {
        for (Car car : cars) {

            car.move(numberStrategy.generate());
        }
        currentRound++;
    }

    public boolean isGameEnd() {
        return currentRound > totalRound;
    }

    public List<Car> getWinner() {
        int max = 1;
        for (Car car : cars) {
            max = Math.max(max, car.getMovement());
        }

        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (max == car.getMovement()) {
                winner.add(car);
            }
        }

        return winner;
    }
}
