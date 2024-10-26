package racingcar.config.validation.validator;

import java.lang.annotation.Annotation;
import racingcar.config.validation.annotation.NotNull;
import racingcar.config.validation.annotation.ValidType;
import racingcar.config.validation.exception.ValidationException;

@ValidType(NotNull.class)
public class NotNullValidator implements Validator {

    public NotNullValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        if (value == null) {
            throw new ValidationException("NULL이 될 수 없습니다.");
        }
    }
}
