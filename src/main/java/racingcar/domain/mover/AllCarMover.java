package racingcar.domain.mover;

import java.util.List;
import racingcar.domain.Car;

public class AllCarMover {

    private final CarMover carMover;

    public AllCarMover(CarMover carMover) {
        this.carMover = carMover;
    }

    public void run(List<Car> cars) {
        cars.forEach(carMover::run);
    }

}
