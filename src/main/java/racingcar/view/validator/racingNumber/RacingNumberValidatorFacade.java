package racingcar.view.validator.racingNumber;

import java.util.ArrayList;
import java.util.List;

public class RacingNumberValidatorFacade {

    private final List<RacingNumberValidator> validators;

    public RacingNumberValidatorFacade() {
        this.validators = new ArrayList<>();
        validators.add(new RacingNumberNullValidator());
        validators.add(new RacingNumberFormatValidator());
    }

    public void validateAll(String input) {
        validators.forEach(validator -> validator.validate(input));
    }
}
