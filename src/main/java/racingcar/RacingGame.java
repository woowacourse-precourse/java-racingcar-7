package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;
    private final GameResult gameResult;


    public RacingGame(List<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.gameResult = new GameResult();

    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            moveAllCars();
        }
    }

    private void moveAllCars() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        }
    }

    public List<String> getWinners() {
        return gameResult.findWinners(cars);
    }
}