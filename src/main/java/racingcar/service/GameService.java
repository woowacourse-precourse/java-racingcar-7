package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.GameStatus;

public class GameService {

    public void progressGame(GameStatus gameStatus, int tryCount) {
        Set<Car> cars = gameStatus.getCar();

        for (int i = 0; i < tryCount; i++) {
            forwardCarByRandomNumber(cars);
        }
    }

    private int forwardCarByRandomNumber(Set<Car> cars) {
        int lastPosition = 0;

        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            System.out.println("car.getName = " + car.getName());
            System.out.println("randomNumber = " + randomNumber);
            if (randomNumber >= 4) {
                int moveCount = car.forwardCar();
            }
            lastPosition = car.getPosition();
            System.out.println("car.getPosition: " + car.getPosition());
            System.out.println("--------------------");
        }
        return lastPosition;
    }
}
