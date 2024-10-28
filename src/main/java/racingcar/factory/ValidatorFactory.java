package racingcar.factory;

import racingcar.validator.AttemptCountValidator;
import racingcar.validator.CarNameValidator;
import racingcar.validator.Validator;

public class ValidatorFactory {

    public static final String TYPE_CAR_NAMES = "Car names";
    public static final String TYPE_ATTEMPT_COUNT = "Attempt Count";

    public Validator create(String type) {
        return switch (type) {
            case TYPE_CAR_NAMES -> new CarNameValidator();
            case TYPE_ATTEMPT_COUNT -> new AttemptCountValidator();
            default -> throw new IllegalArgumentException();
        };
    }
}
