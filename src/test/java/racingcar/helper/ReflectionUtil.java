package racingcar.helper;

import java.lang.reflect.Field;

public class ReflectionUtil {
    public static void forceSetField(Object any, String fieldName, Object value) {
        try {
            Field field = any.getClass().getDeclaredField(fieldName);
            field.trySetAccessible();
            field.set(any, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}