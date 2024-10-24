package racingcar;

import java.util.List;

public class AllCarMover {

    private final CarMover carMover = new CarMover();

    public void run(List<Car> cars) {
        cars.forEach(carMover::run);
    }

}
