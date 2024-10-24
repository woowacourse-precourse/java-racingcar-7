package racingcar;

import java.util.List;

public class Game {

    List<RacingCar> racingCars;

    public void init(List<String> carNames) {
        initCars(carNames);
    }

    public void initCars(List<String> carNames) {
        for (String name : carNames) {
            racingCars.add(RacingCar.createRacingCar(name));
        }
    }
}
