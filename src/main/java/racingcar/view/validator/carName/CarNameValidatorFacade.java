package racingcar.view.validator.carName;

import java.util.ArrayList;
import java.util.List;

public class CarNameValidatorFacade {

    private final List<CarNameValidator> validators;

    public CarNameValidatorFacade() {
        this.validators = new ArrayList<>();
        validators.add(new CarNameDuplicateValidator());
        validators.add(new CarNameLengthValidator());
        validators.add(new CarNameNullValidator());
        validators.add(new CarNameNumberValidator());
    }

    public void validateAll(List<String> carNames) {
        validators.forEach(validator -> validator.validate(carNames));
    }
}
