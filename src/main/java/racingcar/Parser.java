package racingcar;

import java.lang.reflect.InvocationTargetException;

public interface Parser<T, R> {
    static <T, R> Parser<T, R> select(Class<? extends Parser<T, R>> parserClass) throws ReflectiveOperationException {
        return parserClass.getDeclaredConstructor().newInstance();
    }

    R parse(T givenInput);
}
