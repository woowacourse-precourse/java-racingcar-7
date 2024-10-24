package racingcar.model.validator;

import racingcar.model.validator.name.NameValidator;

public interface RacingCarValidator extends NameValidator {

    default void validate(String name) {
        validateName(name);
    }
}
