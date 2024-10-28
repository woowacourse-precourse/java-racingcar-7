package racingcar.model.parseCar;

import java.util.Arrays;
import java.util.List;

public class ParseCar {

    public final static String DELIMITER = ",";

    public static List<String> parseCarName(String carString) {
        return Arrays.stream(carString.split(DELIMITER)).toList();
    }


}
