package racingcar;

import java.util.List;

public class GameController {

    RacingCarList racingCarList = new RacingCarList();

    public GameController(String carNames) {
        racingCarList.add(carNames);
    }

    public void startRun(String attemptCount) {
        List<Car> cars = racingCarList.moveCar(attemptCount);
        String winner = racingCarList.findWinner(cars);
        System.out.println(winner);
    }
}