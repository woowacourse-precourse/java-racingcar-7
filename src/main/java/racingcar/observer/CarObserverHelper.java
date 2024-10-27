package racingcar.observer;

import racingcar.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CarObserverHelper {
    private CarObserverHelper() {
    }

    public static <T extends CarObserver> void addObserverToCar(Car car, Class<T> observerClass, Object... dependencies) {
        try {
            // 생성자 매개변수를 기반으로 인스턴스를 생성
            Constructor<T> constructor = findMatchingConstructor(observerClass, dependencies);
            T observerInstance = constructor.newInstance(dependencies);

            car.addObserver(observerInstance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new IllegalStateException("옵저버 인스턴스를 생성할 수 없습니다.", e);
        }
    }

    private static <T extends CarObserver> Constructor<T> findMatchingConstructor(Class<T> observerClass, Object... dependencies) throws NoSuchMethodException {
        for (Constructor<?> constructor : observerClass.getConstructors()) {
            // 매개변수의 수와 타입이 일치하는 생성자를 찾음
            if (isParameterCountMatching(constructor, dependencies) && areParameterTypesMatching(constructor, dependencies)) {
                return (Constructor<T>) constructor;
            }
        }
        throw new NoSuchMethodException("적절한 생성자를 찾을 수 없습니다.");
    }

    // 생성자의 파라미터 개수가 dependencies의 개수와 일치하는지 확인
    private static boolean isParameterCountMatching(Constructor<?> constructor, Object[] dependencies) {
        return constructor.getParameterTypes().length == dependencies.length;
    }

    // 생성자의 각 파라미터 타입이 dependencies의 타입과 호환되는지 확인 (상속 관계 고려)
    private static boolean areParameterTypesMatching(Constructor<?> constructor, Object[] dependencies) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            if (!parameterTypes[i].isAssignableFrom(dependencies[i].getClass())) {
                return false;
            }
        }
        return true;
    }

}