package racingcar.validator.car.name;

import racingcar.extractor.car.name.CarNameExtractor;
import racingcar.validator.car.name.count.CarNameCountValidator;
import racingcar.validator.car.name.length.CarNameLengthValidator;

public class CarNameValidatorImpl implements CarNameValidator {

    private final CarNameExtractor carNameExtractor;

    private final CarNameLengthValidator carNameLengthValidator;

    private final CarNameCountValidator carNameCountValidator;

    public CarNameValidatorImpl(CarNameExtractor carNameExtractor, CarNameLengthValidator carNameLengthValidator, CarNameCountValidator carNameCountValidator) {
        this.carNameExtractor = carNameExtractor;
        this.carNameLengthValidator = carNameLengthValidator;
        this.carNameCountValidator = carNameCountValidator;
    }

    @Override
    public void validate(String carNameString) {
        String[] carNameList = carNameExtractor.extractFromInputString(carNameString);
        carNameLengthValidator.validate(carNameList);
        carNameCountValidator.validate(carNameList);
    }
}
