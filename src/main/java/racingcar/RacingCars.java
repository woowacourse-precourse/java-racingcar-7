package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private List<RacingCar> racingCarList = new ArrayList<>();

    public RacingCars(String[] racingCarNames) {
        for (String racingCarName : racingCarNames) {
            racingCarList.add(new RacingCar(racingCarName));
        }
    }

    public void moveRacingCars(List<Integer> randomNumbers) {
        for (int i = 0; i < randomNumbers.size(); i++) {
            racingCarList.get(i).forwardRacingCarPosition(randomNumbers.get(i));
        }
    }


}
