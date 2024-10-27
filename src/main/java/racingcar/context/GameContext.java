package racingcar.context;

import java.util.HashMap;
import java.util.Map;

public class GameContext {

    private static Map<Class<?>, Object> attributeMap = new HashMap<>();

    public static void setAttribute(Class<?> classType, Object o) {
        attributeMap.put(classType, o);
    }

    public static Object getAttribute(Class<?> classType) {
        if (attributeMap.containsKey(classType)) {
            return attributeMap.get(classType);
        }

        return null;
    }
}
