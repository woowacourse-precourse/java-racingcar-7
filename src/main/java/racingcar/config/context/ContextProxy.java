package racingcar.config.context;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import racingcar.config.validation.Validation;
import racingcar.config.validation.annotation.Valid;

/**
 * 메서드를 실행하기 이전 특정 작업을 수행하는 프록시 클래스
 */
public class ContextProxy implements InvocationHandler {

    private final Object target;

    public ContextProxy(Object target) {
        this.target = target;
    }

    public static <T> T createProxy(Object target, Class<T> interfaceType) {
        return interfaceType.cast(Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new ContextProxy(target)
        ));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        validation(method, args);

        return method.invoke(target, args);
    }

    private void validation(Method method, Object[] arguments) {
        List<Parameter> parameters = List.of(method.getParameters());

        for (int index = 0; index < parameters.size(); index++) {
            Parameter parameter = parameters.get(index);
            Object argument = arguments[index];

            if (parameter.isAnnotationPresent(Valid.class)) {
                validParameter(parameter, argument);
            }
        }
    }

    private void validParameter(Parameter parameter, Object argument) {
        List<Annotation> annotations = Arrays.stream(parameter.getAnnotations())
                .peek(System.out::println)
                .filter(it -> !it.annotationType().equals(Valid.class))
                .toList();

        for (final Annotation annotation : annotations) {
            Validation.valid(annotation, argument);
        }
    }
}