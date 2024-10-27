package racingcar.model.dependency.validator;

import racingcar.model.dependency.validator.name.NameValidator;

public interface RacingCarValidator extends NameValidator {

    default void validate(String name) {
        validateName(name);
    }
}
