package racingcar.config.validation.validator;

import java.lang.annotation.Annotation;

/**
 * 유효성 검사를 구현하는 클래스
 */
public interface Validator {

    <T> void valid(Annotation annotation, T value);
}