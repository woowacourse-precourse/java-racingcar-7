package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.RacingCarOutput;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private List<RacingCar> cars;
    private Integer number;
    private RacingCarOutput racingCarOutput = new RacingCarOutput();

    public RacingCarService(List<RacingCar> cars, Integer number) {
        this.number = number;
        this.cars = cars;
    }

    public boolean rollMoveDice() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public void moveRacingCars() {
        for (RacingCar car : cars) {
            if (rollMoveDice()) {
                car.moveForward();
            }
        }
    }

    public void startRacing() {
        for (int i = 0; i < number; i++) {
            moveRacingCars();
            racingCarOutput.printCurrentScore(this.cars);
        }
    }
}
