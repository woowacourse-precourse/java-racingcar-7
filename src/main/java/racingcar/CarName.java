package racingcar;


import java.util.Arrays;
import java.util.List;

public class CarName {
    public static List<String> carNameFilter(String input) {
        List<String> carList = Arrays.asList(input.split(","));
        for (String car : carList) {
            if (car.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return carList;
    }
}