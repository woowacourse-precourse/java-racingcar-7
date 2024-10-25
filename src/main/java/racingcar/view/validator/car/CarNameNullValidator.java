package racingcar.view.validator.car;

import static java.util.Objects.isNull;
import static racingcar.util.PreprocessingUtil.stringToStringList;

import java.util.Objects;
import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.view.exception.EmptyInputException;

public class CarNameNullValidator extends CarNameInputValidator {
    private CarNameNullValidator() {
    }

    public static CarNameNullValidator initiate() {
        return new CarNameNullValidator();
    }

    @Override
    public void check(final String source) {
        if (isNull(source) || source.isEmpty() || source.isBlank()) {
            throw new EmptyInputException();
        }

        boolean hasNullObject = stringToStringList(source)
                .stream()
                .anyMatch(Objects::isNull);
        if (hasNullObject) {
            throw new ShouldNotBeNullException();
        }

        super.check(source);
    }
}