package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import racingcar.util.StringUtil;

public class CarFactory {

    public static Cars createCars(String text) {
        List<Car> carList = Arrays.stream(StringUtil.getCarNames(text))
                .map(Car::new).toList();

        return new Cars(carList);
    }
}
