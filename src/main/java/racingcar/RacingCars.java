package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCars(List<String> racingCarNames) {
        for (String racingCarName : racingCarNames) {
            racingCarList.add(new RacingCar(racingCarName));
        }
    }
}
