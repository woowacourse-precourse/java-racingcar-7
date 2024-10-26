package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class TypeConvertUtils {

    private TypeConvertUtils() {}

    public static String carListToString(List<Car> winnerList) {
        List<String> winnerNames = winnerList.stream()
                .map(Car::getName)
                .toList();

        return String.join(",", winnerNames);
    }

    public static List<Car> stringToCarList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
    }
}
