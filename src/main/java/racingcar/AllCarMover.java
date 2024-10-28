package racingcar;

import java.util.List;

public class AllCarMover {

    private final CarMover carMover;

    public AllCarMover(CarMover carMover) {
        this.carMover = carMover;
    }

    public void run(List<Car> cars) {
        cars.forEach(carMover::run);
    }

}
