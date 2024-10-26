package racingcar.validator.car.name;

import racingcar.extractor.car.name.CarNameExtractor;
import racingcar.validator.car.name.length.CarNameLengthValidator;

public class CarNameValidatorImpl implements CarNameValidator {

    private final CarNameExtractor carNameExtractor;

    private final CarNameLengthValidator carNameLengthValidator;

    public CarNameValidatorImpl(CarNameExtractor carNameExtractor, CarNameLengthValidator carNameLengthValidator) {
        this.carNameExtractor = carNameExtractor;
        this.carNameLengthValidator = carNameLengthValidator;
    }

    @Override
    public void validate(String carNameString) {
        String[] carNameList = carNameExtractor.extractFromInputString(carNameString);
        carNameLengthValidator.validate(carNameList);
    }
}
