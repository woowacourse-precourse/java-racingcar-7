package racingcar.model;

import racingcar.utils.CarNameValidator;
import racingcar.utils.CarRacingValidator;
import racingcar.utils.Validator;

import java.util.List;

public class CarRacing {

    private final List<Car> cars;
    private final String carCount;
    Validator validator = new CarRacingValidator();

    public CarRacing(List<Car> cars, String carCount) {
        validator.validation(carCount);
        this.cars = cars;
        this.carCount = carCount;
    }

    public void startRacing() {
        for (Car car : cars) {
            System.out.println(car.getEnginePower());
        }
    }

}
