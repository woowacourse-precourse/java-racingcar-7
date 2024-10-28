package racingcar;

import java.util.ArrayList;
import java.util.List;

public abstract class CarFactory {

    public static RacingCar createRacingCars(String carName) {
        return new RacingCar(carName);
    }
}
