package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RacingGame;

public class RacingCarService {

    public void raceStart(RacingGame racingGame) {
        for (int i = 0; i < racingGame.getTryNumber(); i++) {
            moveCar(racingGame.getRacingCars());
        }
    }

    private void moveCar(RacingCars racingCars) {
        for (Car car : racingCars.getRacingCars()) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
