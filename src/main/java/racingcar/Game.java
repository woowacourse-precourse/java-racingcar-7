package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars;
    private int numberOfRounds;

    public Game(List<Car> cars, int numberOfRounds) {
        this.cars = cars;
        this.numberOfRounds = numberOfRounds;
    }

    public GameResult runRace() {
        for (int i = 0; i < numberOfRounds; i++) {
            moveCars();
        }
        return new GameResult(cars);
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
}
