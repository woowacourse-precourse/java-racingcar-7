package racingcar;

import java.util.List;

public class RaceProgressView {

    public void displayRoundProgress(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            System.out.println(racingCar.getName() + " : " + racingCar.getDistance());
        }
    }

}
