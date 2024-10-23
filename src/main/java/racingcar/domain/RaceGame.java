package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RaceGame {
    private final List<Car> cars;
    private final int totalRound;
    private int currentRound;

    public RaceGame(List<Car> cars, int totalRound) {
        this.cars = cars;
        this.totalRound = totalRound;
        this.currentRound = 1;
    }

    public void race() {
        for (Car car : cars) {
            int generatedNumber = getRandomNumber();
            car.move(generatedNumber);
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

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
