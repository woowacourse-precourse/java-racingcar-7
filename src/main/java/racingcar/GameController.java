package racingcar;

import java.util.List;

// GameManager 클래스명 바꿀까 고민
public class GameController {

    RacingCarList racingCarList = new RacingCarList();

    public GameController(String carName) {
        racingCarList.add(carName);
    }

    public void startRun(String attemptCount) {
        List<Car> cars = racingCarList.moveCar(attemptCount);
        String winner = racingCarList.findWinner(cars);
        System.out.println(winner);
    }
}