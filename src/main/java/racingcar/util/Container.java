package racingcar.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Container {
    private static final Map<Class<?>, Object> CONTAINER = new ConcurrentHashMap<>();

    // 주어진 클래스의 싱글톤 객체를 반환
    public static <T> T getInstance(Class<T> clazz) {
        if (CONTAINER.containsKey(clazz)) {
            return (T) CONTAINER.get(clazz);
        } else {
            T instance = createInstance(clazz);
            CONTAINER.put(clazz, instance);
            return instance;
        }
    }

    // 클래스의 인스턴스를 생성하는 메소드
    private static <T> T createInstance(Class<T> clazz) {
        try {
            // 기본 생성자를 사용하여 객체 생성
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("객체 생성에 실패했습니다: " + clazz.getName(), e);
        }
    }
}