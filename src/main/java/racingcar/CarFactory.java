package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarFactory {

    public static List<Car> generate(String carName) {
        List<Car> racingCars = new ArrayList<>();
        String[] names = carName.split(",");

        Arrays.stream(names)
                .forEach(name -> {
                    if (racingCars.contains(new Car(name))) {
                        throw new IllegalArgumentException("같은 이름을 가진 자동차는 만들 수 없어요.");
                    }

                    racingCars.add(new Car(name));
                });

        return racingCars;
    }
}
