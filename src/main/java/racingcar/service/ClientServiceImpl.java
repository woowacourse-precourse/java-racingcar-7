package racingcar.service;

import racingcar.model.Car;
import racingcar.validate.Validation;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    private static final String COMMA = ",";

    private final List<Car> cars = new ArrayList<>();
    private final Validation validation = new Validation();

    @Override
    public void createCar(String input) {
        String[] carNames = input.split(COMMA);
        for (String car : carNames) {
            validation.isInvalidInput(car);
            validation.isInvalidNameLength(car);
            this.cars.add(new Car(car));
        }
    }

}
