package racingcar.test_data_generator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarGenerator {

    public static Car makeCar(String name, int movedDistance) {
        try {
            Car car = new Car(name);
            Field movedDistanceField = Car.class.getDeclaredField("movedDistance");
            movedDistanceField.setAccessible(true);
            movedDistanceField.set(car, movedDistance);
            return car;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Car 클래스에서 movedDistance 필드를 찾을 수 없습니다.");
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Car 클래스 movedDistance 필드에 접근할 권한이 없습니다.");
        }
    }

    public static List<Car> makeCars(List<String> names) {
        return names.stream().map(Car::new).toList();
    }

    public static List<Car> makeCars(List<String> names, List<Integer> movedDistance) {
        if (names.size() != movedDistance.size()) {
            throw new IllegalArgumentException("Car 리스트를 생성하기 위한 이름과 이동거리의 개수가 맞지 않습니다.");
        }
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            cars.add(makeCar(names.get(i), movedDistance.get(i)));
        }
        return cars;
    }
}
