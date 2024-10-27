package racingcar.domain;

import racingcar.validation.InputValidation;

import java.util.List;

public class GeneralCarFactory implements CarFactory {

    private static CarFactory instance;
    InputValidation validation = new InputValidation();

    private GeneralCarFactory() {
    }

    public static CarFactory getInstance() {
        if (instance == null) instance = new GeneralCarFactory();
        return instance;
    }

    @Override
    public Car createCar(String name) {
        return new Car(name);
    }

    @Override
    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(validation::blankValidation)
                .map(validation::nameLengthValidation)
                .map(this::createCar)
                .toList();
    }
}
