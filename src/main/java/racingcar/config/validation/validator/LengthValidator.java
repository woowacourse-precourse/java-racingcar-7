package racingcar.config.validation.validator;

import java.lang.annotation.Annotation;
import racingcar.config.validation.annotation.Length;
import racingcar.config.validation.annotation.ValidType;
import racingcar.config.validation.exception.ValidationException;

@ValidType(Length.class)
public class LengthValidator implements Validator {

    public LengthValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        try {
            Length lengthAnnotation = (Length) annotation;

            int valueLength = value.toString().length();
            int minLength = lengthAnnotation.min();
            int maxLength = lengthAnnotation.max();

            if (valueLength < minLength || valueLength > maxLength) {
                throw new ValidationException("길이를 만족하지 않습니다.");
            }
        } catch (ClassCastException e) {
            throw new ValidationException("숫자가 아닙니다.");
        }
    }
}
