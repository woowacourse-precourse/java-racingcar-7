package racingcar.domain.car;

import java.util.List;

public class CarService {

    private final CarFactory carFactory;

    public CarService(CarFactory carFactory) {
        this.carFactory = carFactory;
    }

    public Cars makeCars(List<String> carNames) {
        return carFactory.makeCars(carNames);
    }

}
