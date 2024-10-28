package racingcar.config.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.config.validation.exception.NotFoundClassFieldException;

/**
 * 어노테이션 기반으로 필드의 데이터 유효성 검사를 진행하는 클래스
 */
public abstract class FieldValidation {

    private final Class<? extends FieldValidation> cls;

    protected FieldValidation() {
        cls = this.getClass();
    }

    public void valid() {
        List<Field> fields = extractFields();

        for (final Field field : fields) {
            isValid(field);
        }
    }

    private List<Field> extractFields() {
        return Arrays.stream(cls.getDeclaredFields())
                .peek(it -> it.setAccessible(true))
                .collect(Collectors.toList());
    }

    private void isValid(Field field) {
        List<Annotation> annotations = extractAnnotations(field);

        for (Annotation annotation : annotations) {
            try {
                Validation.valid(annotation, field.get(this));
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new NotFoundClassFieldException();
            }
        }
    }

    private List<Annotation> extractAnnotations(Field field) {
        return List.of(field.getAnnotations());
    }
}
