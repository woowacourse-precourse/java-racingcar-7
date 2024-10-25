package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.NameExtractor;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private List<RacingCar> cars = new ArrayList<>();
    private Integer number;

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

    public void printCurrentScore() {
        for (RacingCar car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
    }
}
