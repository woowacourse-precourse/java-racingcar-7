package racingcar.config.validation.validator;

import java.lang.annotation.Annotation;
import racingcar.config.validation.annotation.Min;
import racingcar.config.validation.annotation.ValidType;
import racingcar.config.validation.exception.ValidationException;

@ValidType(Min.class)
public class MinValidator implements Validator {

    public MinValidator() {
    }

    @Override
    public void valid(Annotation annotation, Object value) throws ValidationException {
        try {
            Min minAnnotation = (Min) annotation;
            int minValue = minAnnotation.value();

            if ((int) value < minValue) {
                throw new ValidationException("최솟값을 만족하지 않습니다.");
            }
        } catch (ClassCastException e) {
            throw new ValidationException("숫자가 아닙니다.");
        }
    }
}
