package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class StringSplitter {


    public static List<String> splitString(String carNames){
        return Arrays.stream(carNames.split(",")).toList();
    }
}
