package racingcar.service;

import racingcar.exception.carName.DuplicateCarNameException;
import racingcar.model.Car;
import racingcar.model.factory.CarFactory;
import racingcar.util.DataTransformUtil;
import racingcar.util.ValidationUtil;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static racingcar.util.constant.CharacterConstant.CAR_DELIMITER;

public class RegisterCarService {

    private final ValidationUtil validationUtil;
    private final DataTransformUtil dataTransformUtil;

    public RegisterCarService(ValidationUtil validationUtil, DataTransformUtil dataTransformUtil) {
        this.validationUtil = validationUtil;
        this.dataTransformUtil = dataTransformUtil;
    }

    public List<Car> registerCars(final String input) {
        List<String> carNames = mapToCarNames(input);
        return carNameRegistration(carNames);
    }

    private List<String> mapToCarNames(final String carNameInput) {
        isValidCarNameInput(carNameInput);
        return dataTransformUtil.splitInput(carNameInput, CAR_DELIMITER.getStringValue());
    }

    private List<Car> carNameRegistration(List<String> carNames) {
        validationUtil.isValidCarNameLength(carNames);
        List<Car> cars = CarFactory.convertToCar(carNames);
        carNameDuplicateValidation(cars);
        return cars;
    }

    private boolean carNameDuplicateValidation(List<Car> cars) {
        Set<Car> deduplicationCars = new HashSet<>(cars);
        if(cars.size() != deduplicationCars.size()) {
            throw new DuplicateCarNameException();
        }
        return true;
    }

    private boolean isValidCarNameInput(final String input) {
        validationUtil.isValidRegisterCarsInputLength(input);
        validationUtil.containsInvalidCharacter(input);
        return true;
    }
}
