package racingcar.service;

import racingcar.model.Cars;
import racingcar.model.factory.CarFactory;
import racingcar.util.DataTransformUtil;
import racingcar.util.ValidationUtil;

import java.util.List;

import static racingcar.util.constant.CharacterConstant.CAR_DELIMITER;

public class RegisterCarService {

    private final ValidationUtil validationUtil;
    private final DataTransformUtil dataTransformUtil;

    public RegisterCarService(ValidationUtil validationUtil, DataTransformUtil dataTransformUtil) {
        this.validationUtil = validationUtil;
        this.dataTransformUtil = dataTransformUtil;
    }

    public Cars registerCars(final String input) {
        List<String> carNames = mapToCarNames(input);
        return carNameRegistration(carNames);
    }

    private List<String> mapToCarNames(final String carNameInput) {
        isValidCarNameInput(carNameInput);
        return dataTransformUtil.splitInput(carNameInput, CAR_DELIMITER.getStringValue());
    }

    private Cars carNameRegistration(List<String> carNames) {
        validationUtil.isValidCarNameLength(carNames);
        Cars cars = CarFactory.convertToCar(carNames);
        cars.duplicateValidation();
        return cars;
    }

    private boolean isValidCarNameInput(final String input) {
        validationUtil.isValidRegisterCarsInputLength(input);
        validationUtil.containsInvalidCharacter(input);
        return true;
    }
}
