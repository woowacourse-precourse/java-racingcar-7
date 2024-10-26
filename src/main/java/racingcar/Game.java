package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<RacingCar> init(List<String> carNames) {
        return initCars(carNames);
    }

    public List<RacingCar> initCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(RacingCar.createRacingCar(name));
        }
        return racingCars;
    }

    public List<RacingCar> executeLogic(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            Integer randomNumber = GameUtil.randomNumber();
            if (GameUtil.isForward(randomNumber)) {
                racingCar.addScore();
            }
        }
        return  racingCars;
    }
}
