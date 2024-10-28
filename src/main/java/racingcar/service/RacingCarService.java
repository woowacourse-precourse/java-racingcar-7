package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.RacingCars;
import racingcar.model.RacingGame;
import racingcar.view.RacingCarView;

public class RacingCarService {

    public void raceStart(RacingGame racingGame) {
        for (int i = 0; i < racingGame.getTryNumber(); i++) {
            moveCar(racingGame.getRacingCars());
        }
    }

    private void moveCar(RacingCars racingCars) {

        List<Car> cars = racingCars.getRacingCars();

        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
        RacingCarView.displayMovement(cars);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
