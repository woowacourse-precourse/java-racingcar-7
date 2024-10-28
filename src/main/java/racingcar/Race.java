package racingcar;


import static racingcar.CarCreator.createCar;
import static racingcar.InputHandler.getNames;
import static racingcar.InputHandler.getTryCount;

import java.util.List;

public class Race {

    public void start() {

        List<Car> cars = createCar(getNames());
        int tryCount = getTryCount();

    }

}
