package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            RacingCar newRacingCar = new RacingCar(carName);
            racingCars.add(newRacingCar);
        }
        return racingCars;
    }
}
