package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;

public class RacingUtils {

    private RacingUtils() {}

    public static String carListToString(List<Car> winnerList) {
        List<String> winnerNames = winnerList.stream()
                .map(Car::getName)
                .toList();

        return String.join(",", winnerNames);
    }

    public static List<Car> carNamesToCarList(String carNames) {
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
    }

    private static int getWinnerLocation(List<Car> carList) {
        return carList.stream()
                .mapToInt(Car::getLocation)
                .max()
                .getAsInt();
    }

    public static List<Car> getWinnerCarList(List<Car> carList) {
        int winnerLocation = getWinnerLocation(carList);

        return carList.stream()
                .filter(car -> car.getLocation() == winnerLocation)
                .toList();
    }
}
