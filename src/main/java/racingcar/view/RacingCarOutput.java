package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.List;

public class RacingCarOutput {

    public void printCurrentScore(List<RacingCar> cars){
        for (RacingCar car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
