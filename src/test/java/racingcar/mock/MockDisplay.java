package racingcar.mock;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.game.Display;

public class MockDisplay implements Display {

    @Override
    public void progress(List<Car> cars) {
        //do Nothing
    }

    @Override
    public void winners(List<Car> winners) {
        //do Nothing
    }
}
