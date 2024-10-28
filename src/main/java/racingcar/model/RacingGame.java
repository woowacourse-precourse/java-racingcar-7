package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.view.RacingCarView;

public class RacingGame {

    private RacingCars racingCars;
    private int tryNumber;

    public RacingGame(RacingCars racingCars, int tryNumber) {
        this.racingCars = racingCars;
        this.tryNumber = tryNumber;
    }

    public void raceStart() {
        RacingCarView.printDisplayResultMessage();
        for (int i = 0; i < tryNumber; i++) {
            moveCar();
        }
    }

    public void raceFinish() {
        List<String> raceWinner = racingCars.getRaceWinner();

        if (raceWinner.isEmpty()) {
            RacingCarView.displayNoWinner();
            return;
        }

        RacingCarView.displayWinner(raceWinner);
    }

    private void moveCar() {
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
