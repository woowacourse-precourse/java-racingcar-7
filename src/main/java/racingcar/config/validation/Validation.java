package racingcar.config.validation;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import racingcar.config.context.ClassPathScanner;
import racingcar.config.validation.annotation.ValidType;
import racingcar.config.validation.exception.NotFoundValidatorException;
import racingcar.config.validation.validator.Validator;

/**
 * 어노테이션 기반의 데이터 유효성 검사 클래스
 */
public class Validation {

    private static final Map<Annotation, Validator> instances = new ConcurrentHashMap<>();

    private Validation() {
    }

    public static void valid(Annotation annotation, Object value) {
        Validation instance = Validation.getInstance();
        Validator validator = instance.getValidator(annotation);
        if (validator == null) {
            throw new NotFoundValidatorException();
        }

        validator.valid(annotation, value);
    }

    private static Validation getInstance() {
        return SingletonHelper.SINGLETON;
    }

    private Validator getValidator(Annotation annotation) {
        return instances.computeIfAbsent(annotation, this::createInstanceFromAnnotation);
    }

    private Validator createInstanceFromAnnotation(Annotation annotation) {
        ClassPathScanner scanner = ClassPathScanner.getInstance(Validation.class);
        List<Class<?>> validators = scanner.scan(this::findValidatorClass);

        Class<?> cls = validators.stream()
                .filter(it -> isMatchedAnnotation(it, annotation))
                .findFirst()
                .orElseThrow(NotFoundValidatorException::new);

        return (Validator) createInstance(cls);
    }

    private boolean findValidatorClass(Class<?> cls) {
        return cls.isAnnotationPresent(ValidType.class) && Validator.class.isAssignableFrom(cls);
    }

    private boolean isMatchedAnnotation(Class<?> cls, Annotation annotation) {
        ValidType validType = cls.getAnnotation(ValidType.class);

        return validType.value().equals(annotation.annotationType());
    }

    private <T> T createInstance(Class<T> cls) {
        try {
            return cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    private static class SingletonHelper {

        private static final Validation SINGLETON = new Validation();
    }
}
