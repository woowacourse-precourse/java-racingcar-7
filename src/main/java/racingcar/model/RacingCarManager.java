package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarManager {
    private static final int MINIMUM_RANDOM_NUMBER_TO_MOVE = 4;
    public List<RacingCar> racingCarList;

    public RacingCarManager() {
        racingCarList = new ArrayList<>();
    }

    public void newCar(RacingCar racingCar) {
        racingCarList.add(racingCar);
    }

    public void playRound() {
        for (RacingCar car : racingCarList) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private boolean canMove() {
        return RandomNumberGenerator.generateNumber() >= MINIMUM_RANDOM_NUMBER_TO_MOVE;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }
}
