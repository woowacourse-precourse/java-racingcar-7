package racingcar.car;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public static List<Car> createCars(String names, int moveCondition, int nameLimitLength) {
        String[] carNames = splitName(names);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.length() > nameLimitLength) {
                throw new IllegalArgumentException("이름은 " + nameLimitLength + "자 이하여야 합니다.");
            }
            cars.add(new Car(carName, 0, moveCondition));
        }
        return cars;

    }

    private static String[] splitName(String names) {
        try {
            return names.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException("이름은 쉼표(,)로 구분해야 합니다.", e);
        }
    }
}
