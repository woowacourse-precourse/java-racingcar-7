package racingcar.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class Utils {

    public static ArrayList<String> splitNamesByComma(String carNames) {
        return new ArrayList<>(Arrays.asList(carNames.split(",")));
    }
}
