package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int tryCount;
    private final GameResult gameResult;
    private final RacingGameView view;


    public RacingGame(List<Car> cars, int tryCount, RacingGameView view) {
        this.cars = cars;
        this.tryCount = tryCount;
        this.gameResult = new GameResult();
        this.view = view;

    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            moveAllCars();
            view.printRoundResult(cars);
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