package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class GameService {

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void carRacing(RacingGame racingGame) {
        for (Car car : racingGame.getCars()) {
            int randomNumber = getRandomNumber();
            if (racingGame.getGameRule().moveForward(randomNumber)) {
                car.moveForward();
            }
        }
    }

    public Car createCar(String name) {
        return new Car(name);
    }

}
