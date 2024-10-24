package racingcar.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> splitInputCar(String inputCarName){

        return Arrays.stream(inputCarName.split(","))
                .collect(Collectors.toList());
    }
}
