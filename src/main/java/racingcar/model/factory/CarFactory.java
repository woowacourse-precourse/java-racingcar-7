package racingcar.model.factory;

import static racingcar.util.constant.RegisterCarNumberConstant.PRIME_CAR_DISTANCE;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.Cars;

public class CarFactory {

    public static Cars convertToCar(List<String> carNames) {
        List<Car> carList = carNames.stream().map(carName -> new Car(carName, PRIME_CAR_DISTANCE.getValue())).toList();
        return new Cars(carList);
    }
}
